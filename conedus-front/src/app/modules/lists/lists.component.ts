import { DataSource } from '@angular/cdk/collections';
import { getLocaleCurrencyCode } from '@angular/common';
import { Component } from '@angular/core';
import { Form, FormControl } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { ApiService } from 'src/app/shared/services/api.service';

import { ColegioFiltro } from 'src/app/shared/interfaces/Conedus.interfaces';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-lists',
  templateUrl: './lists.component.html',
  styleUrls: ['./lists.component.css']
})
export class ListsComponent {

  departamentos = new FormControl('');
  municipios = new FormControl('');
  sectores = new FormControl('');
  zonas = new FormControl('');
  componentes = new FormControl('');


  departamentosList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  municipiosList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  sectoresList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  zonasList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  componentesList: string[] = ['Matemáticas', 'Sociales', 'Ciencias', 'Lectura Crítica', 'Inglés'];

  ColegioFiltros: ColegioFiltro[] = [];

  columnas: string[] = ['daneSede', 'nombre', 'clasificacion', 'puntajeGlobal', 'lectura', 'matematicas', 'sociales', 'ciencias', 'ingles'];
  dataSource: MatTableDataSource<ColegioFiltro> = new MatTableDataSource<ColegioFiltro>(this.ColegioFiltros);

  constructor(
    private apiService: ApiService,
  ){}

  ngOnInit(){
    this.getData();
  }

  getData(){
    this.apiService.get<ColegioFiltro[]>('lista')
    .then((lista: ColegioFiltro[]) => {
      this.dataSource = new MatTableDataSource<ColegioFiltro>(lista);
    })
    .catch(err => {
      console.error(err);
      Swal.fire('Error', 'Se presentó un error, contacte al administrador', 'error');
    })
  }

  getMunicipalities(){

  }

}
