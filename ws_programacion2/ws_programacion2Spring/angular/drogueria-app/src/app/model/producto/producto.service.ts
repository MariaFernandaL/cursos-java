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

  constructor(private http: HttpClient) { }

  private urlEndPoint: string = 'http://localhost:8080/api/drogueria/productos';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  
  getProductos(): Observable <Producto[]>{
    return this.http.get(this.urlEndPoint).pipe(
     map(response => response as Producto[])
    );
  }

  crearProducto(Producto:Producto):Observable<Producto> {
    return this.http.post<Producto>(this.urlEndPoint,Producto,{headers:this.httpHeaders});
  }

  getProducto(id): Observable<Producto>{
    return this.http.get<Producto>(`${this.urlEndPoint}/${id}`)
  }

  updateProducto(Producto: Producto): Observable<Producto>{
    return this.http.put<Producto>(`${this.urlEndPoint}/${Producto.idProducto}`, Producto, {headers: this.httpHeaders})
  }

  deleteProducto(id: number): Observable<Producto>{
    return this.http.delete<Producto>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
  
}