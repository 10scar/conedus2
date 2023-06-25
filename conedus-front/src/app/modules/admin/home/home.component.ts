import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Establecimiento, Sede } from 'src/app/shared/interfaces/Conedus.interfaces';
import { ApiService } from 'src/app/shared/services/api.service';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  sedes: Sede[] = [];
  columnas: string[] = ['sede_dane', 'sede_nombre', 'sede_estado', 'promedio_icfes', 'sede_sector', 'sede_telefono', 'sede_direccion', 'sede_email'];

  isCellHovered: boolean = false;

  dataSource: MatTableDataSource<Sede> = new MatTableDataSource<Sede>(this.sedes);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private apiService: ApiService
  ){}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(){
    this.apiService.get<Sede[]>("sede/sedes").then(
      (sedes) => {
        console.log(sedes);
        this.dataSource = new MatTableDataSource<Sede>(sedes);
        this.dataSource.paginator = this.paginator;
      },
      (error) => {
        console.error(error)
      }
    )
  }

  editSchool(codigoDane: string){
    console.log(codigoDane);
  }
}
