import {Component, Injectable, OnInit} from '@angular/core';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {ICustomerType} from '../../../model/customer-type';
import {FormControl, FormGroup, NgForm, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer.service';
import {Router} from '@angular/router';
import {CustomerComponent} from '../customer.component';

@Injectable({providedIn: 'root'})
@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})


export class CustomerCreateComponent implements OnInit {

  private customerType: ICustomerType;

  customerCreateForm: FormGroup;

  customerTypeList: ICustomerType[] = [];

  constructor(private customerTypeService: CustomerTypeService,
              private customerService: CustomerService,
              // private router: Router,
              private customerComponent: CustomerComponent) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();

    this.customerCreateForm = new FormGroup({
        name: new FormControl('', [Validators.required, Validators.pattern(/[A-Za-z+]/), Validators.minLength(6)]),
        dateOfBirth: new FormControl(''),
        gender: new FormControl(''),
        address: new FormControl(''),
        idCard: new FormControl(''),
        phoneNumber: new FormControl(''),
        email: new FormControl(''),
        customerType: new FormControl(1)
      }
    );
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe((data: ICustomerType[]) => {
      this.customerTypeList = data;
    }, error => console.log(error));
  }


  submit() {

    for (const e of this.customerTypeList) {
      if (e.id === this.customerCreateForm.value.customerType) {
        this.customerCreateForm.value.customerType = e;
        break;
      }
    }

    this.customerService.createCustomer(this.customerCreateForm.value).subscribe(data => {
      this.customerComponent.ngOnInit();
    }, error => console.log(error));

    document.getElementById('modalCreate').click();
    console.log(this.customerCreateForm.value);
    this.ngOnInit();
  }

  addNewCustomer() {
    // console.log(this.customerCreateForm.value);
    this.customerService.addNewCustomer(this.customerCreateForm.value).subscribe(data => {
      // this.router.navigateByUrl('app-customer');
    });
  }
}
