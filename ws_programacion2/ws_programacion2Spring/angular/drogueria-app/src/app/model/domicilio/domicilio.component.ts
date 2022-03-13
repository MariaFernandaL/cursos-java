import { Component, OnInit } from '@angular/core';
import { Domicilio } from './domicilio';
import { DOMICILIOSDATA } from './domicilio.json';
import { DomicilioService } from './domicilio.service';

@Component({
  selector: 'app-domicilio',
  templateUrl: './domicilio.component.html',
})
export class DomicilioComponent implements OnInit {
  
  domicilio: Domicilio[];
  constructor(private DomicilioService: DomicilioService) { }


  // ngOnInit(): void {
    //this.domicilio= DOMICILIOSDATA;
 // this.domicilio= this.DomicilioService.getDomicilios();
//}

  ngOnInit(): void {
    this.DomicilioService.getDomicilios().subscribe(
      domicilio=> this.domicilio=domicilio
    );
  }

}
