package com.testing.models;

import com.testing.estructuras.ArrayCircular;
import com.testing.estructuras.LinkedList;
import com.testing.models.Icfes;
public class Sede implements Comparable<Sede>{

    private Establecimiento establecimiento_ref;
    private ArrayCircular<Icfes> icfes;
    private String municipioID;
    private String codigoDane;
    private String nombre;
    private String zona;
    private String direccion;
    private String telefono;
    private String email;
    private String sector;
    private String estado;
    private String[] niveles;
    private String modelos;
    private String[] grados;
    private ArrayCircular<Double> coordenadas;

    public Sede(Establecimiento establecimientoID, String municipioID, String codigoDane, String nombre, String zona, String direccion, String telefono, String email, String sector, String estado, String[] niveles, String modelos, String[] grados, ArrayCircular<Double> coordenadas) {
        this.icfes = new  ArrayCircular<>(1); 
        this.establecimiento_ref = establecimientoID;
        this.municipioID = municipioID;
        this.codigoDane = codigoDane;
        this.nombre = nombre;
        this.zona = zona;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sector = sector;
        this.estado = estado;
        this.niveles = niveles;
        this.modelos = modelos;
        this.grados = grados;
        this.coordenadas = coordenadas;
}
  
    //Setters


    public void setEstablecimientoID(Establecimiento establecimientoID) {
        this.establecimiento_ref = establecimientoID;
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
    public void setNiveles(String[] niveles) {
        this.niveles = niveles;
    }
    public void setModelos(String modelos) {
        this.modelos = modelos;
    }
    public void setGrados(String[] grados) {
        this.grados = grados;
    }
    public void setCoordenadas(ArrayCircular<Double> coordenadas_new) {
        this.coordenadas = coordenadas_new;
    }
    public void setIcfes(ArrayCircular<Icfes> icfes_new) {
        this.icfes = icfes_new;
    }
    
    //Getters
    
    public Establecimiento getEstablecimientoID() {
        return establecimiento_ref;
    }
    public ArrayCircular<Icfes> getIcfes() {
        return icfes;
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
    public String[] getNiveles() {
        return niveles;
    }
    public String getModelos() {
        return modelos;
    }
    public String[] getGrados() {
        return grados;
    }
    public ArrayCircular<Double> getCoordenadas() {
        return coordenadas;
    }

    //metodos compare to 

    public int compareTo(Sede otro) {
        ArrayCircular<Icfes> icfes_otro = otro.getIcfes();
        if(icfes.getSize()<1){
            return 1;
        }else if(icfes_otro.getSize()<1){
            return -1;
        }
        int promedio=0;
        int otro_promedio =0;
        
        for(int i =0;i<icfes.getSize();i++){
            promedio += icfes.get(i).getGlobal();
        }

        for(int i =0;i<icfes.getSize();i++){
            promedio += icfes_otro.get(i).getGlobal();
        }

        return Integer.compare(promedio/icfes.getSize(), otro_promedio/icfes_otro.getSize());
    }


   
    
}
