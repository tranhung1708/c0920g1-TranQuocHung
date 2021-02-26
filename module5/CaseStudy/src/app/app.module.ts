import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CustomerComponent} from './component/customer/customer.component';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {CustomerCreateComponent} from './component/customer/customer-create/customer-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { CustomerDeleteComponent } from './component/customer/customer-delete/customer-delete.component';
import { CustomerUpdateComponent } from './component/customer/customer-update/customer-update.component';
import {AppRoutingModule} from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
