import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-local-app',
  templateUrl: './local-app.component.html',
  styleUrls: ['./local-app.component.css']
})
export class LocalAppComponent implements OnInit {
  output = '';

  constructor(private dateUtilService: DateUtilService) {
  }

  ngOnInit(): void {
  }

  onChange(value) {
    this.output = this.dateUtilService.getDiffToNow(value);
  }
}
