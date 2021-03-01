import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ICustomer} from '../model/customer';
import {Observable} from 'rxjs';


@Injectable({providedIn: 'root'})
export class CustomerService {
  // private url = 'http://localhost:3000/customer';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  private url = 'http://localhost:3000/customer';
  private header = new Headers({'Content-Type': 'application/json'});


  constructor(public http: HttpClient) {
  }

  getAllCustomer() {
    return this.http.get(this.url);
  }

  getAllCustomerHavePagination() {
    return this.http.get(this.url);
  }

  createCustomer(customer: ICustomer) {
    return this.http.post<ICustomer>(this.url, JSON.stringify(customer), this.httpOptions);
  }


  deleteCustomerById(id: number) {
    return this.http.delete(this.url + '/' + id);
  }


  searchByName(name: string) {
    return this.http.get(this.url + '?name_like=' + name);
  }


  getById(id: number): Observable<any> {
    return this.http.get(this.url + '/' + id);
  }

  update(customer: ICustomer, id: number): Observable<any> {
    return this.http.put(this.url + '/' + id, customer);
  }

  updateCustomer(customer: ICustomer) {
    return this.http.put(this.url + '/' + customer.id, customer, this.httpOptions);
  }
}
