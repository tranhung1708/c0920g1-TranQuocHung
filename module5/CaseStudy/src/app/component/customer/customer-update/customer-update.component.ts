import {Component, Injectable, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerComponent} from '../customer.component';
import {AbstractControl, FormBuilder, FormControl, FormGroup, NgForm, Validators} from '@angular/forms';
import {ICustomerType} from '../../../model/customer-type';
import {ICustomer} from '../../../model/customer';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Injectable({providedIn: 'root'})
@Component({
    selector: 'app-customer-update',
    templateUrl: './customer-update.component.html',
    styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit, OnChanges {

    formUpdateCustomer = new FormGroup({
            id: new FormControl(''),
            name: new FormControl('', [Validators.required, Validators.pattern(/[A-Za-z+]/)]),
            dateOfBirth: new FormControl('', this.checkDateOfBirth),
            gender: new FormControl(''),
            address: new FormControl('', [Validators.required, Validators.pattern(/[A-Za-z+]/)]),
            idCard: new FormControl('', [Validators.required, Validators.pattern(/\d{9}/)]),
            phoneNumber: new FormControl('', [Validators.required, Validators.pattern(/(84)\d{10}/)]),
            email: new FormControl('', [Validators.required, Validators.email]),
            customerType: new FormControl('')
        }
    );
    public customerTypeList: ICustomerType[]=[];
    public customerType: ICustomerType | undefined;

    public customerList: ICustomer[];
    customer1: any;

    public customer: ICustomer;

    // public formUpdateCustomer: FormGroup;

    public header: string;
    modalRef: any;

    constructor(private customerService: CustomerService,
                private customerTypeService: CustomerTypeService,
                private fb: FormBuilder,
                private router: Router,
                private route: ActivatedRoute, private  modal: NgbModal) {
    }

    ngOnInit(): void {
        this.getAllCustomerType();
        this.pathData(this.customer1);
    }

    ngOnChanges(changes: SimpleChanges): void {
    }

    pathData(customer: ICustomer) {
        if (customer) {
            this.formUpdateCustomer.patchValue({
                    id: customer.id,
                    name: customer.name,
                    dateOfBirth: customer.dateOfBirth,
                    gender: customer.gender,
                    address: customer.address,
                    idCard: customer.idCard,
                    phoneNumber: customer.phoneNumber,
                    email: customer.email,
                    customerType: customer.customerType.id
                }
            );
        }
    }

    createFormData(): ICustomer{
        const type = this.customerTypeList.find(obj => obj.id===this.formUpdateCustomer.get('customerType').value);
        console.log(type);
        return Object.assign(this.customer1,
            {
                id :this.formUpdateCustomer.get('id').value,
                name: this.formUpdateCustomer.get('name').value,
                dateOfBirth: this.formUpdateCustomer.get('dateOfBirth').value,
                gender: this.formUpdateCustomer.get('gender').value,
                address: this.formUpdateCustomer.get('address').value,
                idCard: this.formUpdateCustomer.get('idCard').value,
                phoneNumber: this.formUpdateCustomer.get('phoneNumber').value,
                email: this.formUpdateCustomer.get('email').value,
                customerType: this.customerTypeList.find(obj => obj.id===this.formUpdateCustomer.get('customerType').value),
            });
    }

    onSubmit() {
        this.customerService.updateCustomer(this.createFormData()).subscribe((data: ICustomer[]) => {
            this.modal.dismissAll(true);
          setTimeout(function() {
            alert('Chỉnh Sửa Thành Công ');
          }, 500);
        });
        // document.getElementById('modalUpdate').click();
    }

    getAllCustomerType() {
        this.customerTypeService.getAll().subscribe((data: ICustomerType[]) => {
            this.customerTypeList = data;
        }, error => console.log(error));
    }

    checkDateOfBirth(abstractControl: AbstractControl): any {
        const value = abstractControl.value;
        const year = Number(value.substr(0, 4));

        return new Date().getFullYear() - year >= 18 ? null : {dateOfBirth: true};
    }
    close() {
        this.modal.dismissAll();
    }

    getAllCustomer(){
      this.customerService.getAllCustomer();
    }
}
