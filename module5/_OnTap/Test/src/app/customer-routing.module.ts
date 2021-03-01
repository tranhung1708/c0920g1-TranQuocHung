import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CustomerComponent} from './customer/customer.component';
import {CustomerCreateComponent} from './customer/customer-create/customer-create.component';
import {CustomerDeleteComponent} from './customer/customer-delete/customer-delete.component';
import {CustomerUpdateComponent} from './customer/customer-update/customer-update.component';
import {ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: '' , pathMatch: 'full'}
];

@NgModule({
  declarations: [CustomerComponent,
    CustomerCreateComponent,
    CustomerDeleteComponent,
    CustomerUpdateComponent,],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
  ]
})
export class CustomerRoutingModule {
}
