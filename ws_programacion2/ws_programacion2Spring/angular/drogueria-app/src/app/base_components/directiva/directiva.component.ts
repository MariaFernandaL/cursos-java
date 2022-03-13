import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva',
  templateUrl: './directiva.component.html',
})
export class DirectivaComponent{

  listaCursos: string[]= ['java', 'Java EE', 'Spring', 'Flutter', 'C++', 'MED'];
  habilitar=true;
  constructor() { }

  setHabilitar(): void{
    this.habilitar=(this.habilitar==true)?false:true;
  }
}
