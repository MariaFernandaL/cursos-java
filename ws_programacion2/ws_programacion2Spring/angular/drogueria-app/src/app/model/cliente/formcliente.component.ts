import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formcliente',
  templateUrl: './formcliente.component.html',
})
export class FormclienteComponent implements OnInit {

  titulo:string="Formulario Clientes";
  cliente: Cliente= new Cliente();

  constructor(
    private ClienteService: ClienteService,
    private router: Router,
    private activateRoute: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.cargarCliente();
  }
  
  

  crearCliente(): void{
      this.ClienteService.crearCliente(this.cliente).subscribe({
        next: (cliente)=> {
          this.router.navigate(['./clientes'])
          Swal.fire({
            title: `Cliente ${this.cliente.nombre} creado con éxito!`,
            imageUrl: 'https://unsplash.it/400/200',
            imageWidth: 400,
            imageHeight: 200,
            imageAlt: 'Custom image',
          });
        },
        error: (e)=>{
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text:'Algo salio mal',
            footer: '<p>Algun dato del formulario esta incorrecto o ya existe, vuelve a intentar</p>'
          });
        }
      })
      }




  cargarCliente():void{
    this.activateRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.ClienteService.getCliente(id).subscribe( (cliente) => this.cliente = cliente )
      }
    })
  }

  actualizarCliente():void{
    this.ClienteService.updateCliente(this.cliente).subscribe(
      cliente =>{
        this.router.navigate(['/clientes'])
        Swal.fire('Cliente Actualizado', `Cliente ${this.cliente.nombre} actualizado con éxito!`, 'success')
      }
    )
  }

}
