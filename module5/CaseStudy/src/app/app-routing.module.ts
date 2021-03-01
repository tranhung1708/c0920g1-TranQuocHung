import {Injectable, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CustomerUpdateComponent} from './component/customer/customer-update/customer-update.component';
import {CustomerCreateComponent} from './component/customer/customer-create/customer-create.component';
import {RouterModule, Routes} from '@angular/router';
import {CustomerComponent} from './component/customer/customer.component';
import {CustomerDeleteComponent} from './component/customer/customer-delete/customer-delete.component';
import {ReactiveFormsModule} from '@angular/forms';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2OrderModule} from 'ng2-order-pipe';
const routes: Routes = [
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: 'customer/home', component: CustomerComponent},
  {path: 'customer/create', component: CustomerCreateComponent},
  {path: 'customer/update/:id', component: CustomerUpdateComponent},
];

@NgModule({
  declarations: [CustomerComponent,
    CustomerCreateComponent,
    CustomerDeleteComponent,
    CustomerUpdateComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    Ng2OrderModule,
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
