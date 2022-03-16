import { Injectable } from '@angular/core';
import { Domicilio } from './domicilio'; 
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { map } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

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
    return this.http.get<Domicilio>(`${this.urlEndPoint}/${id}`)
  }

  updateDomicilio(Domicilio: Domicilio): Observable<Domicilio>{
    return this.http.put<Domicilio>(`${this.urlEndPoint}/${Domicilio.idDomicilio}`, Domicilio, {headers: this.httpHeaders})
  }

  deleteDomicilio(id: number): Observable<Domicilio>{
    return this.http.delete<Domicilio>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
}