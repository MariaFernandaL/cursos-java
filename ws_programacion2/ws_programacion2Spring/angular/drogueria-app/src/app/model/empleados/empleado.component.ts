import { Component, OnInit } from '@angular/core';
import { Empleado } from './empleado';
import { EMPLEADOSDATA } from './empleado.json';
import { EmpleadoService } from './empleado.service'; 
import Swal from 'sweetalert2';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
})
export class EmpleadoComponent implements OnInit {

  empleado: Empleado[];
  constructor(private EmpleadoService: EmpleadoService) { }

ngOnInit(): void {
this.EmpleadoService.getEmpleados().subscribe(
  empleado=> this.empleado=empleado
);
}

delete(empleado: Empleado): void {
  Swal.fire({ 
  title: 'Está seguro??', 
  text: `¿Seguro que desea eliminar al empleado ${empleado.nombre}?`,
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Si, eliminar!',
  cancelButtonText: 'No, cancelar!'
  }).then((result) => {
    if (result.isConfirmed) {
      this.EmpleadoService.deleteEmpleado(empleado.idEmpleado).subscribe(
        response => {
        this.empleado = this.empleado.filter(empleado => empleado !== empleado)
          Swal.fire('Empleado Eliminado!',`Empleado ${empleado.nombre} eliminado con éxito.`,'success')
        }
      )
    }
  }) }


  downloadPDF() {
    const DATA = document.getElementById('htmlData2');
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
      docResult.save(`PDF EMPLEADOS`);
    });
  }
}
