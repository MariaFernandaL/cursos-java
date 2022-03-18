import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTESDATA } from './cliente.json';
import { ClienteService } from './cliente.service';
import Swal from 'sweetalert2';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
})
export class ClienteComponent implements OnInit {

  clientes: Cliente[];
  constructor(private ClienteService: ClienteService) { }

ngOnInit(): void {
this.ClienteService.getClientes().subscribe(
  clientes=> this.clientes=clientes
);
}

delete(cliente: Cliente): void {
  Swal.fire({ 
  title: 'Está seguro??', 
  text: `¿Seguro que desea eliminar al cliente ${cliente.nombre}?`,
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Si, eliminar!',
  cancelButtonText: 'No, cancelar!'
  }).then((result) => {
    if (result.isConfirmed) {
      this.ClienteService.deleteClient(cliente.idCliente).subscribe(
        response => {
        this.clientes = this.clientes.filter(cliente => cliente !== cliente)
          Swal.fire('Cliente Eliminado!',`Cliente ${cliente.nombre} eliminado con éxito.`,'success')
        }
      )
    }
  }) }



  downloadPDF() {
    const DATA = document.getElementById('htmlData');
    const doc = new jsPDF('p', 'pt', 'a4');
    const options = {
      background: 'white',
      scale: 3
    };
    html2canvas(DATA, options).then((canvas) => {

      const img = canvas.toDataURL('image/PNG');
      const bufferX = 15;
      const bufferY = 15;
      const imgProps = (doc as any).getImageProperties(img);
      const pdfWidth = doc.internal.pageSize.getWidth() - 2 * bufferX;
      const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;
      doc.addImage(img, 'PNG', bufferX, bufferY, pdfWidth, pdfHeight, undefined, 'FAST');
      return doc;
    }).then((docResult) => {
      docResult.save(`PDF CLIENTES`);
    });
  }

}
