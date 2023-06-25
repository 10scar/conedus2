import { Component, Optional } from '@angular/core';
import { Sede } from 'src/app/shared/interfaces/Conedus.interfaces';
import { ApiService } from 'src/app/shared/services/api.service';
import { AdminService } from '../admin.service';
import Swal from 'sweetalert2';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-school',
  templateUrl: './school.component.html',
  styleUrls: ['./school.component.css'],
})
export class SchoolComponent {
  readonly sectorsTypes = ['OFICIAL', 'NO OFICIAL'];
  readonly zonesTypes = ['URBANA', 'RURAL'];
  readonly modelsTypes = [
    'Educación para el trabajo y el desarrollo humano',
    'Escuela nueva',
    'Escuela tradicional',
    'Escuela activa',
  ];
  readonly statusTypes = [
    'NUEVO-ACTIVO',
    'ANTIGUO-ACTIVO',
    'CIERRE DEFINITIVO',
    'CIERRE TEMPORAL',
  ];

  posibleFields: any = {
    codigoDane: 'Código DANE',
    coordenadas: 'Coordenadas',
    direccion: 'Dirección',
    email: 'Correo electrónico',
    estado: 'Estado',
    modelos: 'Modelos',
    municipioID: 'Id del municipio',
    nombre: 'Nombre',
    promedio_icfes: 'Promedio del ICFES',
    sector: 'Sector',
    telefono: 'Teléfono',
    zona: 'Zona',
  };

  schoolInfo: any = {
    codigoDane: '',
    nombre: '',
    zona: '',
    direccion: '',
    telefono: '',
    email: '',
    sector: '',
    estado: '',
    modelos: '',
    promedio_icfes: '',
  };

  schoolFields: string[] = [];

  schoolForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private adminService: AdminService,
    private apiService: ApiService,
    private route: ActivatedRoute
  ) {
    this.schoolForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      zona: ['', Validators.required],
      direccion: ['', Validators.required],
      telefono: ['', Validators.required],
      estado: ['', Validators.required],
      sector: ['', Validators.required],
      modelos: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      promedio: new FormControl(0, [Validators.required, Validators.max(500), Validators.min(0)]),
    });
  }

  ngOnInit() {
    let sede = this.adminService.getSede();
    let sedeLocalStorage = this.compareWithId();

    if (sede == undefined) {
      console.log(sedeLocalStorage);
      if (sedeLocalStorage == undefined) {
        return;
      }
      sede = sedeLocalStorage;
    }
    localStorage.setItem('last-school', JSON.stringify(sede));
    this.schoolInfo = sede;

    this.schoolForm.patchValue({
      nombre: this.schoolInfo.nombre,
      zona: this.schoolInfo.zona,
      direccion: this.schoolInfo.direccion,
      telefono: this.schoolInfo.telefono,
      estado: this.schoolInfo.estado,
      sector: this.schoolInfo.sector,
      email: this.schoolInfo.email,
      promedio: parseInt(this.schoolInfo.promedio_icfes),
      modelos: this.schoolInfo.modelos,
    });
  }

  compareWithId() {
    const sedeId = this.route.snapshot.params['id'];
    const lastSchoolString = localStorage.getItem('last-school');
    if (lastSchoolString && sedeId) {
      const lastSchool = JSON.parse(lastSchoolString);
      console.log(lastSchool);
      if (lastSchool.codigoDane == sedeId) {
        return lastSchool;
      }
    }
    return null;
  }

  updateSchool() {
    console.log(this.schoolForm);

    if(this.schoolForm.invalid){
      Swal.fire('Error', 'No se han completado los campos correctamente', 'error');
      return;
    }

    this.schoolInfo.promedio_icfes = this.schoolForm.get('promedio')?.value;
    this.schoolInfo.nombre = this.schoolForm.get('nombre')?.value;
    this.schoolInfo.zona = this.schoolForm.get('zona')?.value;
    this.schoolInfo.direccion = this.schoolForm.get('direccion')?.value;
    this.schoolInfo.telefono = this.schoolForm.get('telefono')?.value;
    this.schoolInfo.email = this.schoolForm.get('email')?.value;
    this.schoolInfo.sector = this.schoolForm.get('sector')?.value;
    this.schoolInfo.estado = this.schoolForm.get('estado')?.value;
    this.schoolInfo.modelos = this.schoolForm.get('modelos')?.value;
    console.log(this.schoolInfo);
    this.apiService.patch(`sede/${this.schoolInfo.sede_dane}`, this.schoolInfo).then(
      (sede) => {
        Swal.fire('Actualizado con éxito');
      },
      (err) => {
        console.error(err);
      }
    )
  }
}
