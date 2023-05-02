import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';

// Angular Material
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  declarations: [
    HeaderComponent
  ],
  imports: [
    CommonModule,
    MatInputModule,
    MatIconModule
  ],
  exports: [
    HeaderComponent,
    MatInputModule,
    MatIconModule
  ]
})
export class SharedModule { }
