import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

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
    if(this.loginForm.controls['username'].value == 'admin' && this.loginForm.controls['password'].value == 'admin'){
      localStorage.setItem('conedus-username', this.loginForm.controls['username'].value);
      localStorage.setItem('conedus-pass', this.loginForm.controls['password'].value);
      this.router.navigate(['admin/home']);
    }
  }

}
