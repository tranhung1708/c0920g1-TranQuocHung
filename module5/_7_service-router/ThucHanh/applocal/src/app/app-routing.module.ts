import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

// tslint:disable-next-line:prefer-const
let TimelinesComponent;
const routes: Routes = [
  {
    path: 'timelines',
    component: TimelinesComponent

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
