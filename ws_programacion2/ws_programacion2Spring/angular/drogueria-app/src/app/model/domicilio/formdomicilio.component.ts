import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Domicilio } from './domicilio'; 
import { DomicilioService } from './domicilio.service'; 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formdomicilio',
  templateUrl: './formdomicilio.component.html',
})
export class FormdomicilioComponent implements OnInit {

  titulo:string="Formulario Domicilios";
  domicilio: Domicilio= new Domicilio();

  
  constructor(
    private DomicilioService: DomicilioService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  crearDomicilio(): void{
    this.DomicilioService.crearDomicilio(this.domicilio).subscribe(
      domicilio=> {
        this.router.navigate(['./domicilios'])
        Swal.fire('Nuevo domicilio', `Domicilio ${this.domicilio.codigo} creado con éxito!`, 'success')
      }
  );
  }


}
