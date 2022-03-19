import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'Drogueria App';
  curso: string = 'Programacion 2';
  texto: string ='Hola 123';
  numero: number=3;
  texto2: string= 'La variable es: ';
  booleano: boolean= false;
}
