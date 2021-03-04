import {Component, OnInit} from '@angular/core';
import {TesstModule} from './model/tesst-module';
import {TestServiceService} from './service/test-service.service';
import {TestModuleComponent} from './test-module/test-module.component';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  testList: TesstModule[];
  tesstModule: TesstModule;
  name: string;
  p: any;

  constructor(private testServiceService: TestServiceService,
              private modal: NgbModal,
              private testModuleService: TestServiceService) {
  }

  getAllTest() {
    this.testServiceService.getAll().subscribe((data: TesstModule[]) => {
      this.testList = data;
      console.log(data);
    }, error => console.log(error));
  }

  ngOnInit(): void {
    this.getAllTest();
  }

  createType(tesstModule: TesstModule) {
    const ref = this.modal.open(TestModuleComponent);
    ref.componentInstance.customer1 = tesstModule;
    ref.result.finally(() => {
      this.getAll();
    });
  }

  private getAll() {
    this.testModuleService.getAll().subscribe((data: TesstModule[]) => {
      this.testList = data;
    });
  }

  search() {
    this.testModuleService.searchByName(this.name).subscribe((data: TesstModule[]) => {
      this.testList = data;
    });
  }

  updateCustomer(tesst: TesstModule) {
    const ref = this.modal.open(TestModuleComponent);
    ref.componentInstance.customer1 = tesst;
  }
}
