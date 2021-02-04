import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {InformationPetComponent} from './information-pet/information-pet.component';

@NgModule({
  declarations: [
    AppComponent,
    InformationPetComponent,
    InformationPetComponent,
    InformationPetComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
