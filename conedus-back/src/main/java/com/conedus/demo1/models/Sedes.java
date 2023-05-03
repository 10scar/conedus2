package com.conedus.demo1.models;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "sedes")
public class Sedes {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sedeID;

    // insertar llave foranea
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "establecimientoID", referencedColumnName = "establecimientoID")
    private int establecimientoID;

    @Column(length = 250, nullable = false)
    private String municipioID;
    @Column(length = 100, nullable = false)
    private String codigoDane;
    @Column(length = 250, nullable = false)
    private String nombre;
    @Column(length = 250, nullable = false)
    private String zona;
    @Column(length = 250, nullable = false)
    private String direccion;
    @Column(length = 100, nullable = false)
    private String telefono;
    @Column(length = 45, nullable = false)
    private String email;
    @Column(length = 250, nullable = false)
    private String sector;
    @Column(length = 250, nullable = false)
    private String estado;
    @Column(length = 250, nullable = false)
    private String niveles;
    @Column(length = 300, nullable = false)
    private String modelos;
    @Column(length = 2505, nullable = false)
    private String grados;
    @Column(nullable = false)
    private float[] coordenadas = new float[2];

    //Setters

    public void setSedeID(int sedeID) {
        this.sedeID = sedeID;
    }
    public void setEstablecimientoID(int establecimientoID) {
        this.establecimientoID = establecimientoID;
    }
    public void setMunicipioID(String municipioID) {
        this.municipioID = municipioID;
    }
    public void setCodigoDane(String codigoDane) {
        this.codigoDane = codigoDane;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setNiveles(String niveles) {
        this.niveles = niveles;
    }
    public void setModelos(String modelos) {
        this.modelos = modelos;
    }
    public void setGrados(String grados) {
        this.grados = grados;
    }
    public void setCoordenadas(float[] coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    //Getters
    
    public int getSedeID() {
        return sedeID;
    }
    public int getEstablecimientoID() {
        return establecimientoID;
    }
    public String getMunicipioID() {
        return municipioID;
    }
    public String getCodigoDane() {
        return codigoDane;
    }
    public String getNombre() {
        return nombre;
    }
    public String getZona() {
        return zona;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
    public String getSector() {
        return sector;
    }
    public String getEstado() {
        return estado;
    }
    public String getNiveles() {
        return niveles;
    }
    public String getModelos() {
        return modelos;
    }
    public String getGrados() {
        return grados;
    }
    public float[] getCoordenadas() {
        return coordenadas;
    }
    
}
