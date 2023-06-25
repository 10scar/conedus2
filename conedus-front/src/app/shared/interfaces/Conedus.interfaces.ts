export interface Colegio {

}

export interface Departamento {
  departamento_id: number;
  departamento_nombre: string;
}

export interface Municipio {
  municipio_id: number;
  municipio_nombre: string;
  departamento_id: number;
}

export interface Coordenadas {
  latitud: number,
  longitud: number
}

export interface Establecimiento {
  establecimiento_id: number;
  municipio_id: number;
  establecimiento_nombre: string;
  establecimiento_dane: string;
  establecimiento_direccion: string;
  establecimiento_telefono: string;
  establecimiento_correo: string;
  establecimiento_rector: string;
  establecimiento_tipo: 'INSTITUCION EDUCATIVA' | 'CENTRO EDUCATIVO';
  establecimiento_jornadas: string;
  establecimiento_etnias: string;
  establecimiento_sector: 'OFICIAL' | 'NO OFICIAL';
  establecimiento_genero: 'MASCULINO' | 'FEMENINO' | 'MIXTO';
  establecimiento_caracter: string;
  establecimiento_licencia: 'SIN REVISAR' | 'CONDICIONAL' | 'DEFINITIVA' | 'RECONOCIMIENTO OFICIAL' | 'REVISADA ACEPTADA' | 'REVISADA NO ACEPTADA';
  establecimiento_modelos: string;
  establecimiento_capacidades_excepcionales: string;
  establecimiento_discapacidades: string;
  establecimiento_idiomas: string;
  establecimiento_estado: 'NUEVO-ACTIVO' | 'ANTIGUO-ACTIVO' | 'CIERRE DEFINITIVO' | 'CIERRE TEMPORAL';
  establecimiento_prestador_servicio: 'OFICIAL' | 'PERSONA NATURAL' | 'FUNDACION O CORPORACIONES' | 'COMUNIDAD RELIGIOSA' | 'SOCIEDAD' | 'EDUCACION MISIONAL CONTRATADA' | 'FEDERACIONES' | 'COOPERATIVO' | 'CAJA DE COMPENSACION' | 'CONCESION' | 'REGIMEN ESPECIAL' | 'COMUNIDAD' | 'UNIVERSIDAD';
  establecimiento_resguardo: 'A' | 'B';
  establecimiento_matricula_contratada: 'OFICIAL' | 'PERSONA NATURAL' | 'FUNDACION O CORPORACIONES' | 'COMUNIDAD RELIGIOSA' | 'SOCIEDAD' | 'EDUCACION MISIONAL CONTRATADA' | 'FEDERACIONES' | 'COOPERATIVO' | 'CAJA DE COMPENSACION' | 'CONCESION' | 'REGIMEN ESPECIAL' | 'COMUNIDAD' | 'UNIVERSIDAD';
  establecimiento_internado: string;
  establecimiento_coordenadas: Coordenadas;
}

export interface Sede {
  sede_id: number;
  establecimiento_id: number;
  municipioID: number;
  sede_dane: string;
  sede_nombre: string;
  sede_zona: 'URBANA' | 'RURAL';
  sede_direccion: string;
  sede_telefono: string;
  sede_email: string;
  sede_sector: 'OFICIAL' | 'NO OFICIAL';
  sede_estado: 'NUEVO-ACTIVO' | 'ANTIGUO-ACTIVO' | 'CIERRE DEFINITIVO' | 'CIERRE TEMPORAL';
  niveles: string;
  grados: string;
  coordenadas: Coordenadas;
  promedio_icfes: string;
  icfes: any;
  establecimiento: any;
}

export interface ColegioInfo {
  establecimientoNombre: string;
  establecimientoDane: string;
  establecimientoDireccion: string;
  establecimientoTelefono: string;
  establecimientoCorreo: string;
  establecimientoRector: string;
  establecimientoSector: 'OFICIAL' | 'NO OFICIAL';
  establecimientoGenero: 'MASCULINO' | 'FEMENINO' | 'MIXTO';
  establecimientoJornadas: 'Mañana' | 'Tarde' | 'Noche' | 'Mañana y tarde' | 'Tarde y noche' | 'Jornada continua';
  sedeZona: 'URBANA' | 'RURAL';
  icfes?: Icfes[]
}

export interface Icfes {
  id: number,
  year: number,
  global: number,
  matematicas: number,
  lectura: number,
  sociales: number,
  ciencias: number,
  ingles: number,
  sedeId: number
}

export interface ColegioPorMunicipio {
  municipio_nombre: string;
  establecimiento_nombre: string;
  establecimiento_sector: 'OFICIAL' | 'NO OFICIAL';
  establecimiento_genero: 'MASCULINO' | 'FEMENINO' | 'MIXTO';
}

export interface MejorColegio extends ColegioPorMunicipio {
  id: number
}

export interface ColegioFiltro {
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


