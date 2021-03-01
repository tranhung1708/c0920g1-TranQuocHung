import {Component, Injectable, OnInit} from '@angular/core';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {ICustomerType} from '../../../model/customer-type';
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerComponent} from '../customer.component';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

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
              private customerComponent: CustomerComponent,
              private  modal: NgbModal) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();

    this.customerCreateForm = new FormGroup({
        name: new FormControl('', [Validators.required, Validators.pattern(/[A-Za-z+]/), Validators.minLength(6)]),
        dateOfBirth: new FormControl('', this.checkDateOfBirth),
        gender: new FormControl(''),
        address: new FormControl('',[Validators.required, Validators.pattern(/[A-Za-z+]/)]),
        idCard: new FormControl('', [Validators.required , Validators.pattern('^[0-9]{9}$')]),
        phoneNumber: new FormControl('' ,[Validators.required , Validators.pattern('^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$')]),
        email: new FormControl('',[Validators.required, Validators.email]),
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
    this.customerService.createCustomer(this.customerCreateForm.value).subscribe(data => {
      // this.customerComponent.ngOnInit();
      this.modal.dismissAll(true)
      setTimeout(function() {
        alert('Thêm Mới Thành Công');
      }, 500);
    }, error => console.log(error));
  }

  checkDateOfBirth(abstractControl: AbstractControl): any {
    const value = abstractControl.value;
    const year = Number(value.substr(0, 4));

    return new Date().getFullYear() - year >= 18 ? null : {dateOfBirth: true};
  }
}
