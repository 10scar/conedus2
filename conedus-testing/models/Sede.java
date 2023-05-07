public class Sede {
    
    private int sedeID;

    private int establecimientoID;
    // private array Circular/lista enlazada de registros icfes

    private String municipioID;
    private String codigoDane;
    private String nombre;
    private String zona;
    private String direccion;
    private String telefono;
    private String email;
    private String sector;
    private String estado;
    private String niveles;
    private String modelos;
    private String grados;
    private float[] coordenadas = new float[2];

    public Sede(int sedeID, int establecimientoID, String municipioID, String codigoDane, String nombre, String zona, String direccion, String telefono, String email, String sector, String estado, String niveles, String modelos, String grados, float[] coordenadas) {
        this.sedeID = sedeID;
        this.establecimientoID = establecimientoID;
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
