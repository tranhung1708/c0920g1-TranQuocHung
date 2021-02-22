import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ICustomer} from '../model/customer';


@Injectable({ providedIn: 'root' })
export class CustomerService {

  private url = 'http://localhost:3000/customer';
  private header = new Headers({'Content-Type': 'application/json'});


  constructor(private http: HttpClient) {}

  getAllCustomer() {
    return this.http.get(this.url);
  }

  getAllCustomerHavePagination(page: number, limit: number) {
    return this.http.get(this.url + '?_limit=' + limit + '&_page=' + page );
  }

  createCustomer(customer: ICustomer) {
    // @ts-ignore
    return this.http.post(this.url, customer, this.header );
  }

  getCustomerById(id: number) {
    return this.http.get(this.url + '/' + id  );
  }

  updateCustomer(customer: ICustomer) {
    // @ts-ignore
    return this.http.put(this.url + '/' + customer.id, customer, this.header );
  }

  deleteCustomerById(id: number) {
    return this.http.delete(this.url + '/' + id);
  }


  searchByName(name: string) {
    return this.http.get(this.url + '?name_like=' + name);
  }
}
