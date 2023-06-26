import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ChartConfiguration, ChartOptions } from 'chart.js';
import { ColegioInfo, Sede } from 'src/app/shared/interfaces/Conedus.interfaces';
import { ApiService } from 'src/app/shared/services/api.service';

@Component({
  selector: 'app-school',
  templateUrl: './school.component.html',
  styleUrls: ['./school.component.css']
})
export class SchoolComponent {

  public schoolInfo!: ColegioInfo;
  public loading: boolean = true;

  public imagenPorJornada: any = {
    'Mañana': 'woman.svg',
    'Tarde': 'woman.svg',
    'Noche': 'woman.svg',
    'Mañana y tarde': 'woman.svg',
    'Tarde y noche': 'woman.svg',
    'Jornada completa': 'woman.svg',
  }

  public lineChartData!: ChartConfiguration<'line'>['data'];

  public lineChartOptions: ChartOptions<'line'> = {
    responsive: false,
    scales: {
      y: {
        type: 'linear',
        display: true,
        position: 'left',
        beginAtZero: true,
        suggestedMax: 100,
        suggestedMin: 0,
      },
      y1: {
        type: 'linear',
        display: true,
        position: 'right',
        beginAtZero: true,
        suggestedMax: 500,
        suggestedMin: 0,
        // grid line settings
        grid: {
          drawOnChartArea: false, // only want the grid lines for one axis to show up
        },
      },
    }
  };

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService
  ){}

  ngOnInit(){
    this.getSchool(this.route.snapshot.params['id']);
  }

  getSchool(id: string){
    this.apiService.get<Sede>(`sede/sede/${id}`).then(
      (sede) => {
        console.log(sede);
        this.schoolInfo = {
          establecimientoCorreo: sede.sede_email,
          establecimientoDane: sede.sede_dane,
          establecimientoDireccion: sede.sede_direccion,
          establecimientoGenero: 'MIXTO',
          establecimientoJornadas: 'Jornada continua',
          establecimientoNombre: sede.sede_nombre,
          establecimientoRector: 'No definido',
          establecimientoSector: sede.sede_sector,
          establecimientoTelefono: sede.sede_telefono,
          sedeZona: sede.sede_zona,
          icfes: sede.icfes
        }
        const years: string[] = [];
        const global: number[] = [];
        const matematicas: number[] = [];
        const sociales: number[] = [];
        const lectura: number[] = [];
        const ciencias:number[] = [];
        const ingles:number[] = [];
        this.schoolInfo.icfes?.forEach(i => {
          years.push(i.year+"")
          global.push(i.global)
          matematicas.push(i.matematicas)
          sociales.push(i.sociales)
          lectura.push(i.lectura)
          ciencias.push(i.ciencias)
          ingles.push(i.ingles)
        })

        this.setCharts(years, global, matematicas, sociales, lectura, ciencias, ingles);
      },
      (err) => {
        console.error(err);
      }
    )
    // this.schoolInfo = {
    //   establecimientoCorreo: 'alexandravargas@example.org',
    //   establecimientoDane: '46289506647',
    //   establecimientoDireccion: 'Calle 9ª # 67-7 195064 Jambaló, Cauca',
    //   establecimientoGenero: 'MIXTO',
    //   establecimientoJornadas: 'Jornada continua',
    //   establecimientoNombre: 'Santos Group',
    //   establecimientoRector: 'Alex Páez',
    //   establecimientoSector: 'NO OFICIAL',
    //   establecimientoTelefono: '+57 3023420779',
    //   sedeZona: 'RURAL'
    // }

    // this.apiService.get<ColegioInfo>(`sede/${id}`).then(schoolInfo => {
    //   this.loading = false;
    //   console.log(schoolInfo);

    // })
  }


  setCharts(years: string[], global: number[], matematicas: number[], sociales: number[], lectura: number[], ciencias: number[], ingles: number[]){
    this.lineChartData = {
      labels: years,
      datasets: [
        {
          data: global,
          label: 'Puntaje Global',
          fill: false,
          tension: 0.8,
          borderColor: 'black',
          yAxisID: 'y1'
        },
        {
          data: matematicas,
          label: 'Matemáticas',
          fill: false,
          tension: 0.8,
          borderColor: 'blue',
          yAxisID: 'y'
        },
        {
          data: sociales,
          label: 'Sociales',
          fill: false,
          tension: 0.8,
          borderColor: 'purple',
          yAxisID: 'y'
        },
        {
          data: lectura,
          label: 'Lectura',
          fill: false,
          tension: 0.8,
          borderColor: 'red',
          yAxisID: 'y'
        },
        {
          data: ingles,
          label: 'Inglés',
          fill: false,
          tension: 0.8,
          borderColor: 'yellow',
          yAxisID: 'y'
        },
        {
          data: ciencias,
          label: 'Ciencias',
          fill: false,
          tension: 0.8,
          borderColor: 'green',
          yAxisID: 'y'
        },
      ]
    };
  }

  getJornadas(){

  }
}
