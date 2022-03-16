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

  constructor(private http: HttpClient) { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/empleados';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getEmpleados(): Observable <Empleado[]>{
    return this.http.get(this.urlEndPoint).pipe(
     map(response => response as Empleado[])
    );
  }

  crearEmpleado(Empleado:Empleado):Observable<Empleado> {
    return this.http.post<Empleado>(this.urlEndPoint,Empleado,{headers:this.httpHeaders});
  }

  getEmpleado(id): Observable<Empleado>{
    return this.http.get<Empleado>(`${this.urlEndPoint}/${id}`)
  }

  updateEmpleado(Empleado: Empleado): Observable<Empleado>{
    return this.http.put<Empleado>(`${this.urlEndPoint}/${Empleado.idEmpleado}`, Empleado, {headers: this.httpHeaders})
  }

  deleteEmpleado(id: number): Observable<Empleado>{
    return this.http.delete<Empleado>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }

  
}
