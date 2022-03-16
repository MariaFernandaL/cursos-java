import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from './producto';
import { ProductoService } from './producto.service'; 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formproductos',
  templateUrl: './formproductos.component.html',
})
export class FormproductosComponent implements OnInit {

  titulo:string="Formulario Productos";
  producto: Producto= new Producto();

  constructor(
    private ProductoService: ProductoService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  crearProducto(): void{
    this.ProductoService.crearProducto(this.producto).subscribe(
      producto=> {
        this.router.navigate(['./productos'])
        Swal.fire('Nuevo producto', `Producto ${this.producto.nombre} creado con éxito!`, 'success')
      }
  );
  }

}
