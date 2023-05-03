import { Component, OnInit } from '@angular/core';
import { Colegio, ColegioPorMunicipio, Coordenadas, Establecimiento } from 'src/app/shared/interfaces/Conedus.interfaces';
import { ApiService } from 'src/app/shared/services/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  mejoresColombia: Establecimiento[] = [];
  colegiosCiudad: ColegioPorMunicipio[] = [
    {
      municipio_nombre: 'BOGOTA',
      establecimiento_genero: 'MIXTO',
      establecimiento_nombre: 'Liceo Campo David',
      establecimiento_sector: 'NO OFICIAL'
    },
    {
      municipio_nombre: 'MEDELLIN',
      establecimiento_genero: 'MIXTO',
      establecimiento_nombre: 'Colegio San Ignacio Loyola',
      establecimiento_sector: 'NO OFICIAL'
    },
    {
      municipio_nombre: 'CALI',
      establecimiento_genero: 'MIXTO',
      establecimiento_nombre: 'Colegio Bilingüe Diana Oese',
      establecimiento_sector: 'NO OFICIAL'
    },
    {
      municipio_nombre: 'BARRANQUILLA',
      establecimiento_genero: 'MIXTO',
      establecimiento_nombre: 'IED Alexander Von Humboldt',
      establecimiento_sector: 'OFICIAL'
    },
    {
      municipio_nombre: 'CARTAGENA',
      establecimiento_genero: 'MIXTO',
      establecimiento_nombre: 'Aspaen Gimnasio Cartagena',
      establecimiento_sector: 'NO OFICIAL'
    },
    {
      municipio_nombre: 'SOACHA',
      establecimiento_genero: 'MIXTO',
      establecimiento_nombre: 'Institución Educativa La Unidad',
      establecimiento_sector: 'NO OFICIAL'
    }
  ];

  accesoUbicacion: boolean = false;

  constructor(
    private apiService: ApiService,
  ){}

  ngOnInit(){
    this.requestLocation();
  }

  async requestLocation(){
    const coordenadas = await this.getLocation();
    console.log(coordenadas);
  }

  getLocation(): Promise<GeolocationPosition> {
    return new Promise((resolve, reject) => {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          (position) => {
            console.log(position);
            this.accesoUbicacion = true;
            resolve(position);
          },
          (error) => {
            this.accesoUbicacion = false;
            console.error('El error es: '+error.message);
            reject(error);
          }
        );
      } else {
        this.accesoUbicacion = false;
        reject("La geolocalización no está disponible en este navegador");
      }
    })
  }


  getBestSchools(){
    this.apiService.get()
      .then((mejores: any) =>
        this.mejoresColombia = mejores.mejoresColombia,

      )
      .catch()
  }
}
