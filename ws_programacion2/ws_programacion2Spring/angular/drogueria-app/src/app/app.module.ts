import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './base_components/header/header.components';
import { FooterComponent } from './base_components/footer/footer.components';
import { DirectivaComponent } from './base_components/directiva/directiva.component';
import { ClienteComponent } from './model/cliente/cliente.component';
import { ClienteService } from './model/cliente/cliente.service';
import { HttpClientModule } from '@angular/common/http';
import { EmpleadoComponent } from './model/empleados/empleado.component';
import { ProductoComponent } from './model/producto/producto.component';
import { DomicilioComponent } from './model/domicilio/domicilio.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectivaComponent,
    ClienteComponent,
    EmpleadoComponent,
    ProductoComponent,
    DomicilioComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ClienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
