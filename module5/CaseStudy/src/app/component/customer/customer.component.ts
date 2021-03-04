import {Component, Injectable, Input, OnInit} from '@angular/core';
import {ICustomer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {CustomerUpdateComponent} from './customer-update/customer-update.component';
import {CustomerDeleteComponent} from './customer-delete/customer-delete.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';

@Injectable({providedIn: 'root'})
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerList: ICustomer[];
  name: string;
  p: any;
  private searchFullName: string;

  constructor(private customerService: CustomerService, private modal: NgbModal) {
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
    this.customerService.getAllCustomerHavePagination().subscribe((data: ICustomer[]) => {
      this.customerList = data;
      console.log(data);
    }, error => console.log(error));
  }

  search() {
    this.customerService.searchByName(this.name).subscribe((data: ICustomer[]) => {
      this.customerList = data;
    }, error => console.log(error));
  }

  searchFull() {
    this.customerService.searchFullName(this.searchFullName).subscribe((data: ICustomer[]) => {
      this.customerList = data;
    }, error => console.log(error));
  }

  returnCustomer(customer: ICustomer) {
    const ref1 = this.modal.open(CustomerDeleteComponent);
    ref1.componentInstance.customer = customer;
    ref1.componentInstance.modalRef = ref1;
    ref1.result.finally(() => {
      this.getAllCustomerHavePagination();
    });
  }

  updateCustomer(customer: ICustomer) {
    const ref = this.modal.open(CustomerUpdateComponent);
    ref.componentInstance.customer1 = customer;
  }

  createCustomer(customer: ICustomer) {
    const ref = this.modal.open(CustomerCreateComponent);
    ref.componentInstance.customer1 = customer;
    ref.result.finally(() => {
      this.getAllCustomerHavePagination();
    });
  }

  key: string = 'id';
  reverse: boolean = false;
  customer: ICustomer;

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

}
