import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import swal from 'sweetalert2';
import { Domicilio } from '../domicilio';
import { DomicilioService } from '../domicilio.service';


@Component({
  selector: 'app-consulta-form',
  templateUrl: './consulta-form.component.html'
})
export class ConsultaFormComponent implements OnInit {

  costo1: number;
  costo2: number;
  domicilios: Domicilio[]= [];

  constructor(private DomicilioService: DomicilioService,
    private router: Router,
     private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    
  }

  consultar():void{
    console.log(this.costo1);
    console.log(this.costo2);
      this.DomicilioService.consultar1(this.costo1, this.costo2).subscribe(
        domicilios=> {
          this.domicilios=domicilios;
          console.log(domicilios);
          swal.fire('Domicilio encontrado', `Domicilio encontrado con éxito!`, 'success')
        }
    );
  }

}