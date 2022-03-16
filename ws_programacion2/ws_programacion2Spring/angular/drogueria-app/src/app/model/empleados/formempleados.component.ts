import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from './empleado'; 
import { EmpleadoService } from './empleado.service'; 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formempleados',
  templateUrl: './formempleados.component.html',
})
export class FormempleadosComponent implements OnInit {

  titulo:string="Formulario Empleados";
  empleado: Empleado= new Empleado();
  
  constructor(
    private EmpleadoService: EmpleadoService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  crearEmpleado(): void{
    this.EmpleadoService.crearEmpleado(this.empleado).subscribe(
      empleado=> {
        this.router.navigate(['./empleados'])
        Swal.fire('Nuevo empleado', `Empleado ${this.empleado.nombre} creado con éxito!`, 'success')
      }
  );
  }
}
