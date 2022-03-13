import { Injectable } from '@angular/core';
import { Domicilio } from './domicilio'; 
import { DOMICILIOSDATA } from './domicilio.json'; 
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { map } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DomicilioService {

  constructor() { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/domicilios';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getDomicilios(): Observable <Domicilio[]>{
    return of (DOMICILIOSDATA);
    //return this.http.get(this.urlEndPoint).pipe(
     //map(response => response as Domicilio[])
    //);
  }
}