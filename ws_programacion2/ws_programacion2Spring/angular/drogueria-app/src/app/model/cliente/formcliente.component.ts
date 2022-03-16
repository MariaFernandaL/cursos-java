import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
    private router: Router
    ) { }

  ngOnInit(): void {
  }

  crearCliente(): void{
    this.ClienteService.crearCliente(this.cliente).subscribe(
      cliente=> {
        this.router.navigate(['./clientes'])
        Swal.fire('Nuevo cliente', `Cliente ${this.cliente.nombre} creado con éxito!`, 'success')
      }
  );
  }


}
