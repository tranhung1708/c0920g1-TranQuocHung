import {Component, OnInit} from '@angular/core';
import {TestServiceService} from '../service/test-service.service';
import {TestModuleTypeService} from '../service/test-module-type.service';
import {FormControl, FormGroup} from '@angular/forms';
import {TestModuleType} from '../model/test-module-type';
import {TesstModule} from '../model/tesst-module';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-test-module',
  templateUrl: './test-module.component.html',
  styleUrls: ['./test-module.component.css']
})
export class TestModuleComponent implements OnInit {
  testModuleForm: FormGroup;
  testTypeList: TestModuleType[] = [];
  testList: TesstModule[];

  constructor(private testModuleService: TestServiceService,
              private tesstModuleType: TestModuleTypeService,
              private modal: NgbModal) {
  }

  ngOnInit(): void {
    this.getAllType();
    this.pathData(this.customer1);
  }
  formTest = new  FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    ngayMoSo: new FormControl(''),
    thoiGianGui: new FormControl(''),
    kiHan: new FormControl(''),
    soTienGui: new FormControl(''),
    laiSuat: new FormControl(''),
    uuDai: new FormControl(''),
    testType: new FormControl('')
  });
  customer1: any;

  public testTypeList1: TestModuleType[] = [];
  public testType: TestModuleType | undefined;
  public testModule: TesstModule;

  getAllType() {
    this.tesstModuleType.getAll().subscribe((data: TestModuleType[]) => {
      this.testTypeList1 = data;
    });
  }

  submit() {
    this.testModuleService.updateTest(this.createFormData()).subscribe((data: TesstModule[]) => {
      this.modal.dismissAll(true);
      setTimeout(function() {
        alert('Thêm Mới Thành Công');
      }, 500);
    });
  }


  private getAll() {
    this.testModuleService.getAll().subscribe((data: TesstModule[]) => {
      this.testList = data;
    });
  }

  close() {
    this.modal.dismissAll();
  }

  private pathData(customer: TesstModule) {
    if (customer) {
      this.formTest.patchValue({
        id: customer.id,
        name: customer.name,
        ngayMoSo: customer.ngayMoSo,
        thoiGianGui: customer.thoiGianGui,
        kiHan: customer.kiHan,
        soTienGui: customer.soTienGui,
        laiSuat: customer.laiSuat,
        uuDai: customer.uuDai,
        testType: customer.testType.id
      });
    }
  }

  createFormData(): TesstModule {
    const type = this.testList.find(obj => obj.id === this.formTest.get('testType').value);
    return Object.assign(this.customer1, {
      id: this.formTest.get('id').value,
      name: this.formTest.get('name').value,
      ngayMoSo: this.formTest.get('ngayMoSo').value,
      thoiGianGui: this.formTest.get('thoiGianGui').value,
      kiHan: this.formTest.get('kiHan').value,
      soTienGui: this.formTest.get('soTienGui').value,
      laiSuat: this.formTest.get('laiSuat').value,
      uuDai: this.formTest.get('uuDai').value,
      testType: this.testTypeList.find(obj => obj.id === this.formTest.get('testType').value)
    });
  }
}
