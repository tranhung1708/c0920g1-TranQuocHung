import {Component, Injectable, OnInit} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomerService} from './service/customer.service';
@Injectable({
  providedIn: 'root'
})
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerList: Customer[];

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe((data: Customer[]) => {
      this.customerList = data;
    });
  }
}
