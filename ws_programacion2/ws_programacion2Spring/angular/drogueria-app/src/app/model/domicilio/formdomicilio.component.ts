import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
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
    private router: Router,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.cargarDomicilio();
  }

  crearDomicilio(): void{
    this.DomicilioService.crearDomicilio(this.domicilio).subscribe(
      domicilio=> {
        this.router.navigate(['./domicilios'])
        Swal.fire('Nuevo domicilio', `Domicilio ${this.domicilio.codigo} creado con éxito!`, 'success')
      }
  );
  }

  cargarDomicilio():void{
    this.activateRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.DomicilioService.getDomicilio(id).subscribe( (domicilio) => this.domicilio = domicilio )
      }
    })
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
