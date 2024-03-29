import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimiComponent } from './primi/primi.component';
import { PrimiListComponent } from './primi-list/primi-list.component';
import { PrimiDetailComponent } from './primi-detail/primi-detail.component';
import { PrimiItemComponent } from './primi-item/primi-item.component';
import { PrimiRoutingModule } from './primi-routing.module';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    PrimiComponent,
    PrimiListComponent,
    PrimiDetailComponent,
    PrimiItemComponent
  ],
  imports: [
    PrimiRoutingModule,
    SharedModule
  ]
})
export class PrimiModule { }
