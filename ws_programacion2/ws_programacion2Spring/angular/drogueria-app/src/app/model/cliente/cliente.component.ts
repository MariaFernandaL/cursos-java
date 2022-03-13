import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTESDATA } from './cliente.json';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
})
export class ClienteComponent implements OnInit {

  cliente: Cliente[];
  constructor(private ClienteService: ClienteService) { }

 // ngOnInit(): void {
    //this.cliente= CLIENTESDATA;
 // this.cliente= this.ClienteService.getClientes();
//}

ngOnInit(): void {
this.ClienteService.getClientes().subscribe(
  cliente=> this.cliente=cliente
);
}
}
