import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
    private router: Router,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.cargarProducto();
  }

  crearProducto(): void{
    this.ProductoService.crearProducto(this.producto).subscribe(
      producto=> {
        this.router.navigate(['./productos'])
        Swal.fire('Nuevo producto', `Producto ${this.producto.nombre} creado con éxito!`, 'success')
      }
  );
  }


  cargarProducto():void{
    this.activateRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.ProductoService.getProducto(id).subscribe( (producto) => this.producto = producto )
      }
    })
  }


  actualizarProducto():void{
    this.ProductoService.updateProducto(this.producto).subscribe(
      producto =>{
        this.router.navigate(['/productos'])
        Swal.fire('Producto Actualizado', `Producto ${this.producto.nombre} actualizado con éxito!`, 'success')
      }
    )
  }

}
