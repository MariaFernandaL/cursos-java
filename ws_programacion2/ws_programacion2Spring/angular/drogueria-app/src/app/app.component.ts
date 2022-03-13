import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'drogueria-app';
  curso: string = 'Programacion 2';
  texto: string ='Hola 123';
  numero: number=3;
  texto2: string= 'La variable es: ';
  booleano: boolean= false;
}
