import {Component, Injectable, Input, OnInit} from '@angular/core';
import {ICustomer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';

@Injectable({providedIn: 'root'})
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerList: ICustomer[];
  customerUpdate: ICustomer = new ICustomer();
  page = 1;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getAllCustomerHavePagination();
  }

  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe((data: ICustomer[]) => {
      this.customerList = data;
    }, error => console.log(error));
  }

  getAllCustomerHavePagination() {
    this.customerService.getAllCustomerHavePagination(this.page, 5).subscribe((data: ICustomer[]) => {
      this.customerList = data;
    }, error => console.log(error));
  }

  search(name) {
    this.customerService.searchByName(name).subscribe((data: ICustomer[]) => {
      this.customerList = data;
    }, error => console.log(error));
  }

  returnCustomer(customer: ICustomer) {
    this.customerUpdate = customer;
  }
}
