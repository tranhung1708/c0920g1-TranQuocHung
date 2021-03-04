import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {TesstModule} from '../model/tesst-module';

@Injectable({
  providedIn: 'root'
})
export class TestServiceService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  private url = ' http://localhost:3000/test-module';

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get(this.url);
  }

  createTest(testModule: TesstModule) {
    return this.http.post<TesstModule>(this.url, JSON.stringify(testModule), this.httpOptions);
  }

  deleteTest(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

  updateTest(testModule: TesstModule) {
    return this.http.put(this.url + '/' + testModule.id, testModule, this.httpOptions);
  }

  searchByName(name: string) {
    return this.http.get(this.url + '?name_like=' + name);
  }
}
