import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../module/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  private API = 'http://localhost:8080/api/customer';

  constructor(private http: HttpClient) {
  }

  getCustomer() {
    return this.http.get(this.API);
  }
}
