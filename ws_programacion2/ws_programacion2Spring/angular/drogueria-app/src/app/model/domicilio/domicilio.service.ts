import { Injectable } from '@angular/core';
import { Domicilio } from './domicilio'; 
import { catchError, Observable, throwError } from 'rxjs';
import { of } from 'rxjs';
import { map } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DomicilioService {

  constructor(private http: HttpClient) { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/domicilios';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getDomicilios(): Observable <Domicilio[]>{
     return this.http.get(this.urlEndPoint).pipe(
     map(response => response as Domicilio[])
    );
  }

  crearDomicilio(Domicilio:Domicilio):Observable<Domicilio> {
    return this.http.post<Domicilio>(this.urlEndPoint,Domicilio,{headers:this.httpHeaders});
  }

  getDomicilio(id): Observable<Domicilio>{
    return this.http.get<Domicilio>(`${this.urlEndPoint}/${id}`);
  }

  updateDomicilio(Domicilio: Domicilio): Observable<Domicilio>{
    return this.http.put<Domicilio>(`${this.urlEndPoint}/${Domicilio.idDomicilio}`, Domicilio, {headers: this.httpHeaders});
  }

  deleteDomicilio(id: number): Observable<Domicilio>{
    return this.http.delete<Domicilio>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }

  consultar1(costo1: number, costo2:number): Observable<Domicilio[]>{
   return this.http.get(`${this.urlEndPoint}/${costo2}/${costo1}`).pipe(
    map(response => response as Domicilio[])
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