import { Injectable } from '@angular/core';
import { Sede } from 'src/app/shared/interfaces/Conedus.interfaces';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private sedeSeleccionada: Sede | undefined;

  constructor() { }

  public setSede(sede: Sede): void {
    this.sedeSeleccionada = sede;
  }

  public getSede(): Sede | undefined {
    return this.sedeSeleccionada;
  }
}
