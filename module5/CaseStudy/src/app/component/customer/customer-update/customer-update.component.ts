import {Component, Injectable, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerComponent} from '../customer.component';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ICustomerType} from '../../../model/customer-type';
import {ICustomer} from '../../../model/customer';

@Injectable({providedIn: 'root'})
@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit, OnChanges {
  public customerTypeList: ICustomerType[];

  public customerList: ICustomer[];

  public customer: ICustomer;

  public idCustomer: any;

  public formUpdateCustomer: FormGroup;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.formUpdateCustomer = new FormGroup({
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

  ngOnChanges(changes: SimpleChanges): void {
  }

  onSubmit() {
    this.idCustomer = this.router
  }
}
