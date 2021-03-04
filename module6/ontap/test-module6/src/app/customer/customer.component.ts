import {Component, OnInit} from '@angular/core';
import {CustomerServiceService} from '../service/customer-service.service';
import {Customer} from '../module/customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerList: Customer[];

  constructor(private customerService: CustomerServiceService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customerService.getCustomer().subscribe((data: Customer[]) => {
      this.customerList = data;
    });
  }

}
