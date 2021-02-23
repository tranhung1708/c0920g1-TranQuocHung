import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @Input() cardName: 'Professional ';
  @Input() email: 'prodev@abc.xyz';
  @Input() phone: '0123456789';
}
