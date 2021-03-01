import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Customer} from '../../model/customer';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  private url = 'http://localhost:3000/customer';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer() {
    return this.httpClient.get(this.url);
  }

  createCustomer(customer: Customer) {
    return this.httpClient.post<Customer>(this.url, JSON.stringify(customer), this.httpOptions);
  }

  deleteCustomerById(id: number) {
    return this.httpClient.delete(this.url + '/' + id);
  }

  searchByName(name: string) {
    return this.httpClient.get(this.url + '?name_like=' + name);
  }

  updateCustomer(customer: Customer) {
    return this.httpClient.put(this.url + '/' + customer.id, customer, this.httpOptions);
  }
}
