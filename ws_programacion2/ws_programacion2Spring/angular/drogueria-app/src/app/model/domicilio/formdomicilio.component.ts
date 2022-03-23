import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Domicilio } from './domicilio'; 
import { DomicilioService } from './domicilio.service'; 
import Swal from 'sweetalert2';
import { Cliente } from '../cliente/cliente';
import { ClienteService } from '../cliente/cliente.service';
import { Producto } from '../producto/producto';
import { Empleado } from '../empleados/empleado';
import { ProductoService } from '../producto/producto.service';
import { EmpleadoService } from '../empleados/empleado.service';

@Component({
  selector: 'app-formdomicilio',
  templateUrl: './formdomicilio.component.html',
})
export class FormdomicilioComponent implements OnInit {

  titulo:string="Formulario Domicilios";
  domicilio: Domicilio= new Domicilio();
  clientes: Cliente[]= [];
  productos: Producto[]= [];
  empleados: Empleado[]= [];



  constructor(
    private DomicilioService: DomicilioService,
    private router: Router,
    private activateRoute: ActivatedRoute,
    private clienteService: ClienteService,
    private productoService: ProductoService,
    private empleadoService: EmpleadoService
  ) { }

  ngOnInit(): void {
    this.cargarDomicilio();
    this.clienteService.getClientes().subscribe(
      clientes=> this.clientes=clientes
    );

    this.empleadoService.getEmpleados().subscribe(
      empleados=> this.empleados=empleados
    );

    this.productoService.getProductos().subscribe(
      productos=> this.productos=productos
    );
    
  }

  crearDomicilio(): void{
    this.buscarCliente(this.domicilio.cliente.idCliente);
    this.buscarProducto(this.domicilio.producto.idProducto);
    this.buscarEmpleado(this.domicilio.empleado.idEmpleado);
      this.DomicilioService.crearDomicilio(this.domicilio).subscribe(
        //{next: ()
        domicilio=> {
          this.router.navigate(['./domicilios'])
          Swal.fire({
            title: `Domicilio ${this.domicilio.codigo} creado con éxito!`,
            imageUrl: 'https://unsplash.it/400/200',
            imageWidth: 400,
            imageHeight: 200,
            imageAlt: 'Custom image',
          });
        }//,
        //error: (e)=>{
         // Swal.fire({
          //  icon: 'error',
           // title: 'Error',
           // text:'Algo salio mal',
           // footer: '<p>Algun dato del domicilio esta incorrecto o ya existe, vuelve a intentar</p>'
        //  });
        //}
      //}
      )
     }

  cargarDomicilio():void{
    this.activateRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.DomicilioService.getDomicilio(id).subscribe( (domicilio) => this.domicilio = domicilio )
      }
    })
  }

  buscarCliente(id:number):void{
    let clienteD: Cliente = new Cliente;
    this.clientes.forEach((clienteeee) =>{
      if(id == clienteeee.idCliente){
        clienteD = clienteeee;
        console.log(clienteD);
      }
    });

    this.domicilio.cliente = clienteD;
  }

  buscarProducto(id:number):void{
    let productoD: Producto = new Producto;
    this.productos.forEach((productoooos) =>{
      if(id == productoooos.idProducto){
        productoD = productoooos;
        console.log(productoD);
      }
    });
    this.domicilio.producto = productoD;
  }

  buscarEmpleado(id:number):void{
    let empleadoD: Empleado = new Empleado;
    this.empleados.forEach((empleadoooos) =>{
      if(id == empleadoooos.idEmpleado){
        empleadoD = empleadoooos;
        console.log(empleadoD);
      }
    });
    this.domicilio.empleado = empleadoD;
  }
  


  actualizarDomicilio():void{
    this.DomicilioService.updateDomicilio(this.domicilio).subscribe(
      domicilio =>{
        this.router.navigate(['/domicilios'])
        Swal.fire('Domicilio Actualizado', `Domicilio ${this.domicilio.codigo} actualizado con éxito!`, 'success')
      }
    )
  }

}
