package com.conedus.demo1.models;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "establecimientos")
public class Establecimientos {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int establecimientoID;

    @Column(length = 45, nullable = false)
    private String municipioID;
    @Column(length = 250, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String codigoDane;
    @Column(length = 350, nullable = false)
    private String direccion;
    @Column(length = 250, nullable = false)
    private String telefono;
    @Column(length = 250, nullable = false)
    private String correo;
    @Column(length = 250, nullable = false)
    private String rector;
    @Column(length = 250, nullable = false)
    private String tipo;
    @Column(length = 250, nullable = false)
    private String jornadas;
    @Column(length = 100, nullable = false)
    private String etnias;
    @Column(length = 250, nullable = false)
    private String sector;
    @Column(length = 250, nullable = false)
    private String genero;
    @Column(length = 100, nullable = false)
    private String caracter;
    @Column(length = 250, nullable = false)
    private String licencia;
    @Column(length = 350, nullable = false)
    private String modelos;
    @Column(length = 250, nullable = false)
    private String capacidadesExcepcionales;
    @Column(length = 250, nullable = false)
    private String discapacidades;
    @Column(length = 250, nullable = false)
    private String idiomas;
    @Column(length = 250, nullable = false)
    private String estado;
    @Column(length = 250, nullable = false)
    private String prestadorServicio;
    @Column(length = 250, nullable = false)
    private String calendario;
    @Column(length = 250, nullable = false)
    private String prestadorPlanta;
    @Column(length = 100, nullable = false)
    private String resguardo;
    @Column(nullable = false)
    private int matriculaContratada;
    @Column(length = 100, nullable = false)
    private String internado;
    @Column(nullable = false)
    private float[] coordenadas = new float[2];

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