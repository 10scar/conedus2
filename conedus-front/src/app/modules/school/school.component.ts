import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ColegioInfo } from 'src/app/shared/interfaces/Conedus.interfaces';
import { ApiService } from 'src/app/shared/services/api.service';

@Component({
  selector: 'app-school',
  templateUrl: './school.component.html',
  styleUrls: ['./school.component.css']
})
export class SchoolComponent {

  schoolInfo!: ColegioInfo;
  loading: boolean = true;

  imagenPorJornada: any = {
    'Mañana': 'woman.svg',
    'Tarde': 'woman.svg',
    'Noche': 'woman.svg',
    'Mañana y tarde': 'woman.svg',
    'Tarde y noche': 'woman.svg',
    'Jornada completa': 'woman.svg',
  }

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService
  ){}

  ngOnInit(){
    console.log(this.route);
    this.getSchool('s');
  }

  getSchool(id: string){
    this.schoolInfo = {
      establecimientoCorreo: 'alexandravargas@example.org',
      establecimientoDane: '46289506647',
      establecimientoDireccion: 'Calle 9ª # 67-7 195064 Jambaló, Cauca',
      establecimientoGenero: 'MIXTO',
      establecimientoJornadas: 'Jornada continua',
      establecimientoNombre: 'Santos Group',
      establecimientoRector: 'Alex Páez',
      establecimientoSector: 'NO OFICIAL',
      establecimientoTelefono: '+57 3023420779',
      sedeZona: 'RURAL'
    }
    // this.apiService.get<ColegioInfo>(`sede/${id}`).then(schoolInfo => {
    //   this.loading = false;
    //   console.log(schoolInfo);

    // })
  }

  getJornadas(){

  }
}
