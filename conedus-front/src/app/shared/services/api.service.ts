import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';


export interface Usuario {
  nombre: string,
  edad: number,
  apellido: string
}


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private readonly url: string = 'https://api.conedus.com';

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Origin': 'https://api.conedus.com'
    })
  };

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

  put<T>(endpoint: string, body: T): Promise<T> {
    return new Promise((resolve, reject) => {
      this.http.put<T>(`${this.url}/api/${endpoint}`, body, this.httpOptions).subscribe(
        (response: T) => {
          resolve(response)
        },
        (err) => {
          console.error('Error en la petición PUT');
          reject(err);
        }
      )
    })
  }

}
