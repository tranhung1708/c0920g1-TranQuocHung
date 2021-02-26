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

  getAllCustomerHavePagination(page: number, limit: number) {
    return this.http.get(this.url + '?_limit=' + limit + '&_page=' + page);
  }

  createCustomer(customer: ICustomer) {
    // @ts-ignore
    // return this.http.post(this.url, customer, this.header );
    return this.http.post<ICustomer>(this.url, JSON.stringify(customer), this.httpOptions);
  }

  getCustomerById(id: number) {
    return this.http.get(this.url + '/' + id);
  }

  updateCustomer(customer: ICustomer) {
    // @ts-ignore
    return this.http.put(this.url + '/' + customer.id, customer, this.header);
  }

  deleteCustomerById(id: number) {
    return this.http.delete(this.url + '/' + id);
  }


  searchByName(name: string) {
    return this.http.get(this.url + '?name_like=' + name);
  }

  addNewCustomer(customer): Observable<any> {
    return this.http.post(this.url, customer);
  }

  getById(id: number): Observable<any> {
    return this.http.get(this.url + '/' + id);
  }

  update(customer: ICustomer, id: number): Observable<any> {
    return this.http.put(this.url + '/' + id, customer);
  }
}
