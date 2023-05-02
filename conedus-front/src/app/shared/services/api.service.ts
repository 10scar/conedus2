import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';


export interface Usuario {
  nombre: string,
  edad: number,
  apellido: string
}


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http: HttpClient
  ) { }

  get(): Promise<string> {
    return new Promise((resolve, reject) => {
      // this.http.get<Usuario[]>('api/usuarios/').subscribe((response) => {

      // })
    })
  }
}
