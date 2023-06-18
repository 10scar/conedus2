import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SchoolComponent } from './school.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule, Routes } from '@angular/router';
import { NgChartsModule } from 'ng2-charts';

const routes: Routes = [
  {
    path: ':id',
    component: SchoolComponent
  },
]

@NgModule({
  declarations: [
    SchoolComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(routes),
    NgChartsModule
  ]
})
export class SchoolModule { }
