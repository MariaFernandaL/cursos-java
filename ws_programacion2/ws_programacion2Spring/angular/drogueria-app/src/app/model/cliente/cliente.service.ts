import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { catchError, Observable, throwError } from 'rxjs';
import { of } from 'rxjs';
import { map } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/clientes';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getClientes(): Observable <Cliente[]>{
    return this.http.get(this.urlEndPoint).pipe(
     map(response => response as Cliente[])
     );
  }

  crearCliente(Cliente:Cliente):Observable<Cliente> {
    return this.http.post<Cliente>(this.urlEndPoint,Cliente,{headers:this.httpHeaders})
    .pipe(
      catchError(this.errores)
    );
  }

  getCliente(id): Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`)
  }

  updateCliente(cliente: Cliente): Observable<Cliente>{
    return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.idCliente}`, cliente, {headers: this.httpHeaders})
  }

  deleteClient(id: number): Observable<Cliente>{
    return this.http.delete<Cliente>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
    .pipe(
      catchError(this.errores)
    );
  }


  private errores(error: HttpErrorResponse){
    if(error.status==0){
      console.error("Error en: ", error.error);
    } else{
      console.error(`Codigo de retorno del backend ${error.status}, body was: `, error.error);
    }
    return throwError(()=> new Error("Algo esta mal, intentalo de nuevo"));
  }



}
