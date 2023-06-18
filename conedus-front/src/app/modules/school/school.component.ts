import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ChartConfiguration, ChartOptions } from 'chart.js';
import { ColegioInfo } from 'src/app/shared/interfaces/Conedus.interfaces';
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
    this.lineChartData = {
      labels: [2020, 2021, 2022],
      datasets: [
        {
          data: [350, 320, 270],
          label: 'Puntaje Global',
          fill: false,
          tension: 0.8,
          borderColor: 'black',
          yAxisID: 'y1'
        },
        {
          data: [90, 56, 77],
          label: 'Matemáticas',
          fill: false,
          tension: 0.8,
          borderColor: 'blue',
          yAxisID: 'y'
        },
        {
          data: [45, 53, 75],
          label: 'Sociales',
          fill: false,
          tension: 0.8,
          borderColor: 'purple',
          yAxisID: 'y'
        },
        {
          data: [90, 67, 70],
          label: 'Lectura',
          fill: false,
          tension: 0.8,
          borderColor: 'red',
          yAxisID: 'y'
        },
        {
          data: [30, 45, 63],
          label: 'Inglés',
          fill: false,
          tension: 0.8,
          borderColor: 'yellow',
          yAxisID: 'y'
        },
        {
          data: [94, 56, 58],
          label: 'Ciencias',
          fill: false,
          tension: 0.8,
          borderColor: 'green',
          yAxisID: 'y'
        },
      ]
    };
    // this.apiService.get<ColegioInfo>(`sede/${id}`).then(schoolInfo => {
    //   this.loading = false;
    //   console.log(schoolInfo);

    // })
  }


  getJornadas(){

  }
}
