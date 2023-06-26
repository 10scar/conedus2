import { DataSource } from '@angular/cdk/collections';
import { getLocaleCurrencyCode } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { Form, FormControl, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { ApiService } from 'src/app/shared/services/api.service';

import {
  ColegioFiltro,
  Departamento,
  Municipio,
} from 'src/app/shared/interfaces/Conedus.interfaces';
import Swal from 'sweetalert2';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lists',
  templateUrl: './lists.component.html',
  styleUrls: ['./lists.component.css'],
})
export class ListsComponent {
  departamento: FormControl<Departamento> = new FormControl();
  municipio: FormControl<Municipio> = new FormControl();
  sector = new FormControl('');
  zona = new FormControl('');
  componentes = new FormControl('');
  puntajeGlobal = new FormControl(null, [
    Validators.min(0),
    Validators.max(500),
  ]);

  departamentosList: Departamento[] = [];
  municipiosList: Municipio[] = [];
  municipiosSaved: Municipio[] = [];
  sectoresList: string[] = ['OFICIAL', 'NO OFICIAL'];
  zonasList: string[] = ['URBANA', 'RURAL'];
  componentesList: string[] = [
    'Matemáticas',
    'Sociales',
    'Ciencias',
    'Lectura Crítica',
    'Inglés',
  ];

  ColegioFiltros: ColegioFiltro[] = [];

  columnas: string[] = [
    'daneSede',
    'nombre',
    'clasificacion',
    'puntajeGlobal',
    'lectura',
    'matematicas',
    'sociales',
    'ciencias',
    'ingles',
  ];
  dataSource: MatTableDataSource<ColegioFiltro> =
    new MatTableDataSource<ColegioFiltro>(this.ColegioFiltros);

  @ViewChild(MatPaginator) paginator!: MatPaginator;


  constructor(
    private apiService: ApiService,
    private router: Router,
  ) {}

  ngOnInit() {
    this.getData();
    this.getFilters();
    this.setObservers();
  }

  getData() {
    this.apiService
      .get<ColegioFiltro[]>('sede/lists')
      .then((lista: ColegioFiltro[]) => {
        console.log(lista);
        this.dataSource = new MatTableDataSource<ColegioFiltro>(lista);
        this.dataSource.paginator = this.paginator;
      })
      .catch((err) => {
        console.error(err);
        Swal.fire(
          'Error',
          'Se presentó un error, contacte al administrador',
          'error'
        );
      });
  }

  getFilters() {
    this.apiService.get<Departamento[]>('sede/departamentos').then(
      (departamentos) => {
        this.departamentosList = departamentos;
        console.log(this.departamentosList);
      },
      (err) => {
        console.error(err);
      }
    );
    this.apiService.get<Municipio[]>('sede/municipios').then(
      (municipios) => {
        this.municipiosSaved = municipios;
      },
      (err) => {
        console.error(err);
      }
    );
  }

  setObservers() {
    this.departamento.valueChanges.subscribe(() => {
      this.getMunicipalitiesFromDep();
    });
  }

  getMunicipalitiesFromDep() {
    if (this.departamento.value != null) {
      const num: number = this.departamento.value.departamento_id;
      this.municipiosList = this.municipiosSaved.filter(
        (m) => m.municipio_id === num
      );
    }
  }

  filter() {
    console.log(`sede/filtro/${
      this.departamento.value ? this.departamento.value.departamento_id : 'NA'
    }/${this.municipio.value ? this.municipio.value.municipio_id : 'NA'}/${
      this.sector.value ? this.sector.value : 'NA'
    }/${this.zona.value ? this.zona.value : 'NA'}/${
      this.puntajeGlobal.value ? this.puntajeGlobal.value : 0
    }`)
    this.apiService.get<ColegioFiltro[]>(
      `sede/filtro/${
        this.departamento.value ? this.departamento.value.departamento_id : 'NA'
      }/${this.municipio.value ? this.municipio.value.municipio_id : 'NA'}/${
        this.sector.value ? this.sector.value : 'NA'
      }/${this.zona.value ? this.zona.value : 'NA'}/${
        this.puntajeGlobal.value ? this.puntajeGlobal.value : 0
      }`
    ).then(
      (filtrados) => {
        console.log('llega la rta', filtrados);
        this.dataSource = new MatTableDataSource<ColegioFiltro>(filtrados);
        this.dataSource.paginator = this.paginator;
      },
      (err) => {
        console.error(err);
      }
    );
  }

  goToSchool(element: ColegioFiltro){
    console.log(element);
    this.router.navigate([`establecimiento/${element.codigoDane}`]);
  }
}
