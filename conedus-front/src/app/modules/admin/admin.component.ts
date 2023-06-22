import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import * as bcryptjs from 'bcryptjs';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router
  ){
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(){
    if(this.loginForm.invalid){
      return;
    }

    this.onSubmit();
  }

  onSubmit(){
    localStorage.setItem('conedus-username', this.loginForm.controls['username'].value);
    localStorage.setItem('conedus-pass', bcryptjs.hashSync(this.loginForm.controls['password'].value));
    this.router.navigate(['admin/home']);
  }

}
