package com.testing.models;

public class Establecimiento {

    private int establecimientoID;
    private String municipioID;
    private String nombre;
    private String codigoDane;
    private String direccion;
    private String telefono;
    private String correo;
    private String rector;
    private String tipo;
    private String jornadas;
    private String etnias;
    private String sector;
    private String genero;
    private String caracter;
    private String licencia;
    private String modelos;
    private String capacidadesExcepcionales;
    private String discapacidades;
    private String idiomas;
    private String estado;
    private String prestadorServicio;
    private String calendario;
    private String prestadorPlanta;
    private String resguardo;
    private int matriculaContratada;
    private String internado;
    private float[] coordenadas = new float[2];
    // private ArrayCircular/lista enlazada de tipo Sede. Agregar constructor con este argumento

    public Establecimiento(int id, String municipioID, String nombre, String codigoDane, String direccion, String telefono, String correo, String rector, String tipo, String jornadas, String etnias, String sector, String genero, String caracter, String licencia, String modelos, String capacidadesExcepcionales, String discapacidades, String idiomas, String estado, String prestadorServicio, String calendario, String prestadorPlanta, String resguardo, int matriculaContratada, String internado, float[] coordenadas){
    this.establecimientoID = id;
    this.municipioID = municipioID;
    this.nombre = nombre;
    this.codigoDane = codigoDane;
    this.direccion = direccion;
    this.telefono = telefono;
    this.correo = correo;
    this.rector = rector;
    this.tipo = tipo;
    this.jornadas = jornadas;
    this.etnias = etnias;
    this.sector = sector;
    this.genero = genero;
    this.caracter = caracter;
    this.licencia = licencia;
    this.modelos = modelos;
    this.capacidadesExcepcionales = capacidadesExcepcionales;
    this.discapacidades = discapacidades;
    this.idiomas = idiomas;
    this.estado = estado;
    this.prestadorServicio = prestadorServicio;
    this.calendario = calendario;
    this.prestadorPlanta = prestadorPlanta;
    this.resguardo = resguardo;
    this.matriculaContratada = matriculaContratada;
    this.internado = internado;
    this.coordenadas = coordenadas;
}

  

    //Setters
    
    public void setEstablecimientoID(int establecimientoID) {
        this.establecimientoID = establecimientoID;
    }
    public void setMunicipioID(String municipioID) {
        this.municipioID = municipioID;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigoDane(String codigoDane) {
        this.codigoDane = codigoDane;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setRector(String rector) {
        this.rector = rector;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setJornadas(String jornadas) {
        this.jornadas = jornadas;
    }
    public void setEtnias(String etnias) {
        this.etnias = etnias;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    public void setModelos(String modelos) {
        this.modelos = modelos;
    }
    public void setCapacidadesExcepcionales(String capacidadesExcepcionales) {
        this.capacidadesExcepcionales = capacidadesExcepcionales;
    }
    public void setDiscapacidades(String discapacidades) {
        this.discapacidades = discapacidades;
    }
    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setPrestadorServicio(String prestadorServicio) {
        this.prestadorServicio = prestadorServicio;
    }
    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }
    public void setPrestadorPlanta(String prestadorPlanta) {
        this.prestadorPlanta = prestadorPlanta;
    }
    public void setResguardo(String resguardo) {
        this.resguardo = resguardo;
    }
    public void setMatriculaContratada(int matriculaContratada) {
        this.matriculaContratada = matriculaContratada;
    }
    public void setInternado(String internado) {
        this.internado = internado;
    }
    public void setCoordenadas(float[] coordenadas) {
        this.coordenadas = coordenadas;
    }
    public String getNombre() {
        return nombre;
    }

    //Getters

    public int getEstablecimientoID() {
        return establecimientoID;
    }
    public String getMunicipioID() {
        return municipioID;
    }
    public String getCodigoDane() {
        return codigoDane;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public String getRector() {
        return rector;
    }
    public String getTipo() {
        return tipo;
    }
    public String getJornadas() {
        return jornadas;
    }
    public String getEtnias() {
        return etnias;
    }
    public String getSector() {
        return sector;
    }
    public String getGenero() {
        return genero;
    }
    public String getCaracter() {
        return caracter;
    }
    public String getLicencia() {
        return licencia;
    }
    public String getModelos() {
        return modelos;
    }
    public String getCapacidadesExcepcionales() {
        return capacidadesExcepcionales;
    }
    public String getDiscapacidades() {
        return discapacidades;
    }
    public String getIdiomas() {
        return idiomas;
    }
    public String getEstado() {
        return estado;
    }
    public String getPrestadorServicio() {
        return prestadorServicio;
    }
    public String getCalendario() {
        return calendario;
    }
    public String getPrestadorPlanta() {
        return prestadorPlanta;
    }
    public String getResguardo() {
        return resguardo;
    }
    public int getMatriculaContratada() {
        return matriculaContratada;
    }
    public String getInternado() {
        return internado;
    }
    public float[] getCoordenadas() {
        return coordenadas;
    }

}
