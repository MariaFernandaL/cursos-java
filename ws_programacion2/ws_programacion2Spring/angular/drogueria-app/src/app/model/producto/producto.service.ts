import { Injectable } from '@angular/core';
import { Producto } from './producto';  
import { PRODUCTOSDATA } from './producto.json'; 
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { map } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor() { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/productos';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getProductos(): Observable <Producto[]>{
    return of (PRODUCTOSDATA);
    //return this.http.get(this.urlEndPoint).pipe(
     //map(response => response as Producto[])
    //);
  }
  
}