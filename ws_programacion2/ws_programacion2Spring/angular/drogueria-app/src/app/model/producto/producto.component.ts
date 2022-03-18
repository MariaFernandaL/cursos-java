import { Component, OnInit } from '@angular/core';
import { Producto } from './producto'; 
import { PRODUCTOSDATA } from './producto.json'; 
import { ProductoService } from './producto.service'; 
import Swal from 'sweetalert2';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
})
export class ProductoComponent implements OnInit {

  producto: Producto[];
  constructor(private ProductoService: ProductoService) { }

ngOnInit(): void {
this.ProductoService.getProductos().subscribe(
  producto=> this.producto=producto
);
}

delete(producto: Producto): void {
  Swal.fire({ 
  title: 'Está seguro??', 
  text: `¿Seguro que desea eliminar el producto ${producto.nombre}?`,
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Si, eliminar!',
  cancelButtonText: 'No, cancelar!'
  }).then((result) => {
    if (result.isConfirmed) {
      this.ProductoService.deleteProducto(producto.idProducto).subscribe(
        response => {
        this.producto = this.producto.filter(producto => producto !== producto)
          Swal.fire('Producto Eliminado!',`Producto ${producto.nombre} eliminado con éxito.`,'success')
        }
      )
    }
  }) }

  downloadPDF() {
    const DATA = document.getElementById('htmlData3');
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
      docResult.save(`PDF PRODUCTOS`);
    });
  }

}
