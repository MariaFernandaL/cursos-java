import { Component, OnInit } from '@angular/core';
import { Producto } from './producto'; 
import { PRODUCTOSDATA } from './producto.json'; 
import { ProductoService } from './producto.service'; 

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
}
