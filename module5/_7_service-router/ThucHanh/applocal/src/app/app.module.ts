import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LocalAppComponent } from './local-app/local-app.component';
import {RouterModule} from '@angular/router';
import { YoutubePlaylistComponent } from './youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './youtube-player/youtube-player.component';

@NgModule({
  declarations: [
    AppComponent,
    LocalAppComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent
  ],
    imports: [
        BrowserModule,
        RouterModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
