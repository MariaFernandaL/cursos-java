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

  constructor(private http: HttpClient) { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/clientes';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getClientes(): Observable <Cliente[]>{
    return this.http.get(this.urlEndPoint).pipe(
     map(response => response as Cliente[])
     );
  }

  crearCliente(Cliente:Cliente):Observable<Cliente> {
    return this.http.post<Cliente>(this.urlEndPoint,Cliente,{headers:this.httpHeaders});
  }

  getCliente(id): Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`)
  }

  updateCliente(cliente: Cliente): Observable<Cliente>{
    return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.idCliente}`, cliente, {headers: this.httpHeaders})
  }

  deleteCliente(id: number): Observable<Cliente>{
    return this.http.delete<Cliente>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }


}
