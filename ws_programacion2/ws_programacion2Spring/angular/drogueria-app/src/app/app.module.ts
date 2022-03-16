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
import { RouterModule, Routes } from '@angular/router';
import { FormclienteComponent } from './model/cliente/formcliente.component';
import { FormsModule } from '@angular/forms';
import { FormempleadosComponent } from './model/empleados/formempleados.component';
import { FormproductosComponent } from './model/producto/formproductos.component';
import { FormdomicilioComponent } from './model/domicilio/formdomicilio.component';

const routes: Routes=[
  {path: '', redirectTo: '/drogueria', pathMatch:'full'},
  {path: 'clientes', component: ClienteComponent},
  {path: 'directivas', component: DirectivaComponent},
  {path: 'empleados', component: EmpleadoComponent},
  {path: 'productos', component: ProductoComponent},
  {path: 'domicilios', component: DomicilioComponent},
  {path: 'clientes/formcliente', component: FormclienteComponent},
  {path: 'empleados/formempleados', component: FormempleadosComponent},
  {path: 'productos/formproductos', component: FormproductosComponent},
  {path: 'domicilios/formdomicilio', component: FormdomicilioComponent}
]

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
      FormclienteComponent,
      FormempleadosComponent,
      FormproductosComponent,
      FormdomicilioComponent
    ],
  
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ClienteService],
  bootstrap: [AppComponent]
})
export class AppModule {
}


