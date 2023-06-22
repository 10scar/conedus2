import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { RouterModule, Routes } from '@angular/router';
import { SharedModule } from 'src/app/shared/shared.module';
import { AdminGuard } from './admin.guard';
import { HomeComponent } from '../home/home.component';


const routes: Routes = [
  {
    path: '',
    component: AdminComponent
  },
  {
    path: 'home',
    canActivate: [AdminGuard],
    loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
  }
]


@NgModule({
  declarations: [
    AdminComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(routes)
  ],
  providers: [AdminGuard]
})
export class AdminModule { }
