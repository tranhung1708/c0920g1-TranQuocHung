import {Component, Injectable, Input, OnInit} from '@angular/core';
import {ICustomer} from '../../../model/customer';
import {CustomerService} from '../../../service/customer.service';
import {CustomerComponent} from '../customer.component';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Injectable({providedIn: 'root'})
@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  customer: ICustomer;

  constructor(private customerService: CustomerService,
              private customerComponent: CustomerComponent,
              private  modal: NgbModal) {
  }

  ngOnInit(): void {
  }

  deleteCustomer() {
    this.customerService.deleteCustomerById(this.customer.id).subscribe(data => {
      this.modal.dismissAll();
      setTimeout(function() {
        alert('Xóa Thành Công');
      }, 500);
      // this.customerComponent.ngOnInit();
    }, error => console.log(error));
  }

  close() {
    this.modal.dismissAll();
  }
}
