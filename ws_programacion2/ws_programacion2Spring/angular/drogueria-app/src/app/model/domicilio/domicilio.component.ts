import { Component, OnInit } from '@angular/core';
import { Domicilio } from './domicilio';
import { DomicilioService } from './domicilio.service';
import Swal from 'sweetalert2';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-domicilio',
  templateUrl: './domicilio.component.html',
})
export class DomicilioComponent implements OnInit {
  
  domicilio: Domicilio[];
  constructor(private DomicilioService: DomicilioService) { }

  ngOnInit(): void {
    this.DomicilioService.getDomicilios().subscribe(
      domicilio=> this.domicilio=domicilio
    );
  }

  delete(domicilio: Domicilio): void {
    Swal.fire({ 
    title: 'Está seguro??', 
    text: `¿Seguro que desea eliminar el domicilio ${domicilio.codigo}?`,
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, eliminar!',
    cancelButtonText: 'No, cancelar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.DomicilioService.deleteDomicilio(domicilio.idDomicilio).subscribe(
          response => {
          this.domicilio = this.domicilio.filter(domicilio => domicilio !== domicilio)
            Swal.fire('Domicilio Eliminado!',`Domicilio ${domicilio.codigo} eliminado con éxito.`,'success')
          }
        )
      }
    }) }


    downloadPDF() {
      const DATA = document.getElementById('htmlData4');
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
        docResult.save(`PDF DOMICILIOS`);
      });
    }

}
