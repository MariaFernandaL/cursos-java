import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Domicilio } from './domicilio'; 
import { DomicilioService } from './domicilio.service'; 
import Swal from 'sweetalert2';
import { Cliente } from '../cliente/cliente';
import { ClienteService } from '../cliente/cliente.service';

@Component({
  selector: 'app-formdomicilio',
  templateUrl: './formdomicilio.component.html',
})
export class FormdomicilioComponent implements OnInit {

  titulo:string="Formulario Domicilios";
  domicilio: Domicilio= new Domicilio();
  clientes: Cliente[]= [];



  constructor(
    private DomicilioService: DomicilioService,
    private router: Router,
    private activateRoute: ActivatedRoute,
    private clieteService: ClienteService
  ) { }

  ngOnInit(): void {
    this.cargarDomicilio();
  }

  crearDomicilio(): void{
    this.buscarCliente(this.domicilio.cliente);
      this.DomicilioService.crearDomicilio(this.domicilio).subscribe({
        next: (domicilio)=> {
          this.router.navigate(['./domicilios'])
          Swal.fire({
            title: `Domicilio ${this.domicilio.codigo} creado con éxito!`,
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
            footer: '<p>Algun dato del domicilio esta incorrecto o ya existe, vuelve a intentar</p>'
          });
        }
      })
      }

  cargarDomicilio():void{
    this.activateRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.DomicilioService.getDomicilio(id).subscribe( (domicilio) => this.domicilio = domicilio )
      }
    })
  }

  buscarCliente(nombre:any):void{
    let clienteD: Cliente = new Cliente;
    this.clientes.forEach((clienteeee) =>{
      if(nombre == clienteeee.nombre){
        clienteD = clienteeee;
        console.log(clienteD);
      }
    });

    this.domicilio.cliente = clienteD;
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
