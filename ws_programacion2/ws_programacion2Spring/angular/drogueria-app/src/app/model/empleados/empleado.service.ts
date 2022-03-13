import { Injectable } from '@angular/core';
import { Empleado } from './empleado'; 
import { EMPLEADOSDATA } from './empleado.json';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { map } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  constructor() { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/empleados';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getEmpleados(): Observable <Empleado[]>{
    return of (EMPLEADOSDATA);
    //return this.http.get(this.urlEndPoint).pipe(
     //map(response => response as Empleado[])
    //);
  }

  
}
