import {Component, Injectable, Input, OnInit} from '@angular/core';
import {ICustomer} from '../../../model/customer';
import {CustomerService} from '../../../service/customer.service';
import {CustomerComponent} from '../customer.component';
@Injectable({providedIn: 'root'})
@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  @Input() customer: ICustomer;

  constructor(private customerService: CustomerService,
              private customerComponent: CustomerComponent) {
  }

  ngOnInit(): void {
  }

  deleteCustomer() {
    this.customerService.deleteCustomerById(this.customer.id).subscribe(data => {
      document.getElementById('modalDelete').click();

      // tslint:disable-next-line:only-arrow-functions
      setTimeout(function() {
        alert('Delete successfully');
      }, 500);

      this.customerComponent.ngOnInit();

    }, error => console.log(error));
  }
}
