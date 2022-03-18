import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
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
    private router: Router,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.cargarEmpleado();
  }

  crearEmpleado(): void{
    this.EmpleadoService.crearEmpleado(this.empleado).subscribe(
      empleado=> {
        this.router.navigate(['./empleados'])
        Swal.fire('Nuevo empleado', `Empleado ${this.empleado.nombre} creado con éxito!`, 'success')
      }
  );
  }

  cargarEmpleado():void{
    this.activateRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.EmpleadoService.getEmpleado(id).subscribe( (empleado) => this.empleado = empleado )
      }
    })
  }

  actualizarEmpleado():void{
    this.EmpleadoService.updateEmpleado(this.empleado).subscribe(
      empleado =>{
        this.router.navigate(['/empleados'])
        Swal.fire('Empleado Actualizado', `Empleado ${this.empleado.nombre} actualizado con éxito!`, 'success')
      }
    )
  }


}
