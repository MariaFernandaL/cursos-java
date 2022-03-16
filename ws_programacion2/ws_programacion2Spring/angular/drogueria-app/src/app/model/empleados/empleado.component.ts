import { Component, OnInit } from '@angular/core';
import { Empleado } from './empleado';
import { EMPLEADOSDATA } from './empleado.json';
import { EmpleadoService } from './empleado.service'; 

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
})
export class EmpleadoComponent implements OnInit {

  empleado: Empleado[];
  constructor(private EmpleadoService: EmpleadoService) { }

ngOnInit(): void {
this.EmpleadoService.getEmpleados().subscribe(
  empleado=> this.empleado=empleado
);
}
}
