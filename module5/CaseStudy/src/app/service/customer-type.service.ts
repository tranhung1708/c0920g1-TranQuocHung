import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable()

export class CustomerTypeService {

  private url = 'http://localhost:3000/customerType';

  constructor(private http: HttpClient) {
  }


  getAll() {
    return this.http.get(this.url);
  }
}
