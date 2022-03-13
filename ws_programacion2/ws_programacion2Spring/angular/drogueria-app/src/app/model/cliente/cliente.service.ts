import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTESDATA } from './cliente.json';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { map } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor() { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/clientes';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getClientes(): Observable <Cliente[]>{
    return of (CLIENTESDATA);
    //return this.http.get(this.urlEndPoint).pipe(
     //map(response => response as Cliente[])
    //);
  }

  
}
