import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService, IWord} from '../dictionary-service.service';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {

  listWord: IWord[] = [];
  constructor(
    private dictionaryService: DictionaryServiceService,
  ) { }

  ngOnInit() {
    this.listWord = this.dictionaryService.getAll();
  }

}
