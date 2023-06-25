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

  url: string = 'http://ec2-15-229-60-182.sa-east-1.compute.amazonaws.com:8090';

  constructor(
    private http: HttpClient
  ) { }

  get<T>(endpoint: string): Promise<T> {
    return new Promise((resolve, reject) => {
      this.http.get<T>(`${this.url}/api/${endpoint}`).subscribe(
        (response: T) => {
          resolve(response)
        },
        (err) => {
          console.error('Error en la petición GET');
          reject(err);
        }
      )
    })
  }

  patch<T>(endpoint: string, body: T): Promise<T> {
    return new Promise((resolve, reject) => {
      this.http.patch<T>(`${this.url}/api/${endpoint}`, body).subscribe(
        (response: T) => {
          resolve(response)
        },
        (err) => {
          console.error('Error en la petición PATCH');
          reject(err);
        }
      )
    })
  }

}
