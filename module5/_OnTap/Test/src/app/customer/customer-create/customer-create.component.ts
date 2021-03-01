import {Component, OnInit} from '@angular/core';
import {CustomerType} from '../../model/customer-type';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerService} from '../service/customer.service';
import {CustomerTypeService} from '../service/customer-type.service';
import {CustomerComponent} from '../customer.component';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  private customerType = CustomerType;

  customerCreateForm: FormGroup;

  customerTypeList: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private customerComponent: CustomerComponent) {
  }

  ngOnInit(): void {
    this.getAllCustomertype();
    this.customerCreateForm = new FormGroup({
      name: new FormControl(''),
      dayOfBirth: new FormControl(''),
      address: new FormControl(''),
      customerType: new FormControl('')
    });
  }

  getAllCustomertype() {
    this.customerTypeService.getAll().subscribe((data: CustomerType[]) => {
      this.customerTypeList = data;
    }, error => console.log(error));
  }

  submit() {
    this.getAllCustomertype();
    this.customerService.createCustomer(this.customerCreateForm.value).subscribe(data => {
      this.customerComponent.ngOnInit();
    }, error => console.log(error));
    this.ngOnInit();
  }
}
