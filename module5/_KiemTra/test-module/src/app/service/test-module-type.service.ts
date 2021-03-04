import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TestModuleTypeService {

  private url = 'http://localhost:3000/test-module-type';

  constructor(private  http: HttpClient) {
  }

  getAll() {
    return this.http.get(this.url);
  }
}
