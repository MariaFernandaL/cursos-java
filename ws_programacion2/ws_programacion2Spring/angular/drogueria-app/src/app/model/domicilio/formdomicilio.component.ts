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
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-formdomicilio',
  templateUrl: './formdomicilio.component.html',
})
export class FormdomicilioComponent implements OnInit {

  titulo:string="Formulario Domicilios";
  domicilio: Domicilio= new Domicilio();
  cliente:Cliente;
  empleado:Empleado;
  producto:Producto;
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

    this.clienteService.getClientes().subscribe(clientes=> this.clientes=clientes);

    this.empleadoService.getEmpleados().subscribe(
      empleados=> this.empleados=empleados
    );

    this.productoService.getProductos().subscribe(
      productos=> this.productos=productos
    );
    
  }

  crearDomicilio(): void{
    this.buscarCliente(this.domicilio.cliente);
    this.buscarEmpleado(this.domicilio.empleado);
    this.buscarProducto(this.domicilio.producto);
    console.log(this.domicilio.cliente.nombre);
    console.log(this.domicilio.empleado.nombre);
    console.log(this.domicilio.producto.nombre);

    this.DomicilioService.crearDomicilio(this.domicilio).subscribe({
        next: (domiclio)=> {
          this.router.navigate(['./domicilios'])
          Swal.fire({
            title: `Domicilio ${this.domicilio.codigo} creado con éxito!`,
            imageUrl: 'https://unsplash.it/400/200',
            imageWidth: 400,
            imageHeight: 200,
            imageAlt: 'Custom image',
          })
        },
        error: (e)=>{
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text:'Algo salio mal',
           footer: '<p>Algun dato del domicilio esta incorrecto o ya existe, vuelve a intentar</p>'
          })
        }
      });
     }


  cargarDomicilio():void{
    this.activateRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.DomicilioService.getDomicilio(id).subscribe( (domicilio) => this.domicilio = domicilio )
      }
    })
  }

  buscarCliente(nombre:any):Cliente{
    let clienteD: Cliente = new Cliente();
    this.clientes.forEach((clienteeee) =>{
      if(nombre == clienteeee.nombre){
        clienteD = clienteeee;
        console.log(clienteD);
      }
    });
    return this.domicilio.cliente = clienteD;
  }

  buscarProducto(nombre:any):Producto{
    let productoD: Producto = new Producto();
    this.productos.forEach((productoooos) =>{
      if(nombre == productoooos.nombre){
        productoD = productoooos;
        console.log(productoD);
      }
    });
    return this.domicilio.producto = productoD;
  }

  buscarEmpleado(nombre:any):Empleado{
    let empleadoD: Empleado = new Empleado;
    this.empleados.forEach((empleadoooos) =>{
      if(nombre == empleadoooos.nombre){
        empleadoD = empleadoooos;
        console.log(empleadoD);
      }
    });
    return this.domicilio.empleado = empleadoD;
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
