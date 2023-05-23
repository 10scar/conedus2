import { DataSource } from '@angular/cdk/collections';
import { Component } from '@angular/core';
import { Form, FormControl } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';

interface Example {
  daneSede: number,
  nombre: string,
  clasificacion: string,
  puntajeGlobal: number,
  lectura: number,
  sociales: number,
  ciencias: number,
  matematicas: number,
  ingles: number,
}

@Component({
  selector: 'app-lists',
  templateUrl: './lists.component.html',
  styleUrls: ['./lists.component.css']
})
export class ListsComponent {

  departamentos = new FormControl('');
  municipios = new FormControl();
  sectores = new FormControl();
  zonas = new FormControl();
  componentes = new FormControl();


  departamentosList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  municipiosList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  sectoresList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  zonasList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  componentesList: string[] = ['Matemáticas', 'Sociales', 'Ciencias', 'Lectura Crítica', 'Inglés'];

  examples: Example[] = [];

  columnas: string[] = ['daneSede', 'nombre', 'clasificacion', 'puntajeGlobal', 'lectura', 'matematicas', 'sociales', 'ciencias', 'ingles'];
  dataSource: MatTableDataSource<Example> = new MatTableDataSource<Example>(this.examples);

}
