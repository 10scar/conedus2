package com.conedus.backend.sede_funtions;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conedus.backend.estructuras.*;
import com.conedus.backend.models.Establecimiento;
import com.conedus.backend.models.Icfes;
import com.conedus.backend.models.Sede;

public class FiltradorTabla {

    //crea una tabla hash vacia por defecto al creaar el objeto filtro
    public HashTable<String,Sede> hash_colegios; 
    @Autowired
     JdbcTemplate jdbcTemplate;

    public FiltradorTabla(JdbcTemplate jdbc){
        hash_colegios = new HashTable<>();
        jdbcTemplate = jdbc;
    }

    public com.conedus.backend.estructuras.LinkedList get_data_filter(ArrayCircular<String> filtros) {
        
        String sql = "SELECT * FROM ouvxvkkq_conedus_pruebas.sedes limit 200000";
        String valorColumna1 = null;
        Sede nueva_sede;
        String municipioID;
        String codigoDane;
        String nombre;
        String zona;
        String direccion;
        String telefono;
        String email;
        String sector;
        String estado;
        String[] niveles;
        String modelos;
        String[] grados;
        ArrayCircular<Double> coordenadas;
        float promedio_icfes=0;
        String key; // key para hashtable
        int filtro_global = Integer.valueOf(filtros.get(4));

        // Ejecutar la consulta
        Establecimiento default_establecimiento = new Establecimiento(valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, null, 0, valorColumna1, null);
        List<Map<String, Object>> resultados = jdbcTemplate.queryForList(sql);
   
        int pro_count = 0;
        // Procesar los resultados
        for (Map<String, Object> fila : resultados) {
            ArrayCircular<String> datos_colegio = new ArrayCircular<>(2);
            pro_count++;
            //traer datos
            int sede_id = (Integer) fila.get("sede_id");
            ArrayCircular<Icfes> icfes = new ArrayCircular<>(2);

            //get_icfes(icfes, sede_id);
        
            municipioID= Integer.toString((int) fila.get("municipio_id"));
            codigoDane= (String) fila.get("sede_dane");
            nombre= (String) fila.get("sede_nombre");
            zona= (String) fila.get("sede_zona");
            direccion= (String) fila.get("sede_direccion");
            telefono= (String) fila.get("sede_telefono");
            email= (String) fila.get("sede_email");
            sector= (String) fila.get("sede_sector");
            estado= (String) fila.get("sede_estado");
            niveles =new String[0];
            modelos= (String) fila.get("sede_modelos");;
            grados=new String[0];;
            coordenadas= new ArrayCircular<>(2);

            //datos para el filtro
            datos_colegio.pushBack(municipioID);
            datos_colegio.pushBack(municipioID);
            datos_colegio.pushBack(sector);
            datos_colegio.pushBack(zona);
            

            nueva_sede = new Sede(default_establecimiento, municipioID, codigoDane, nombre, zona, direccion, telefono, email, sector, estado, niveles, modelos, grados, coordenadas);    
            nueva_sede.setIcfes(icfes);

            
            key = key_filter(filtros,datos_colegio);
            if(key ==filtros.stringkey()){
                System.out.println(key);
            }
            
            if(nueva_sede.getPromedioIcfes()>= filtro_global || filtro_global==0){ 
                hash_colegios.add(key, nueva_sede);
            }
            
            
            
        }
       
        return hash_colegios.getChainWithKey(filtros.stringkey());
    }


        public void get_icfes(ArrayCircular<Icfes> array,Integer sedes_id){
        String sql = "SELECT * FROM ouvxvkkq_conedus_pruebas.icfes where sedes_id ="+sedes_id;
        List<Map<String, Object>> resultados = jdbcTemplate.queryForList(sql);
        Icfes nuevo_icfes;
        int año;
        int global;
        int matematicas;
        int lectura;
        int sociales;
        int ciencias;
        int ingles;
     
        for (Map<String, Object> fila : resultados) {
            año = Integer.parseInt((String) fila.get("icfes_year"));
            global= (Integer) fila.get("icfes_global");
            matematicas= (Integer) fila.get("icfes_matematicas");
            lectura= (Integer) fila.get("icfes_lectura");
            sociales= (Integer) fila.get("icfes_sociales");
            ciencias= (Integer) fila.get("icfes_ciencias");
            ingles= (Integer) fila.get("icfes_ingles");
            nuevo_icfes = new Icfes(año, global, matematicas, lectura, sociales, ciencias, ingles);
            array.pushBack(nuevo_icfes);
        }
    }

    public String key_filter(ArrayCircular<String> filtros, ArrayCircular<String> datos){
        String key = "";
        //recorrem,os las opciones del filtro menos la de academico y si esta agregamos al string la opcion si no dejamos como NA
        for(int i = 0;i< filtros.getSize()-1;i++){
            if(filtros.get(i)!="NA"){
            key+=datos.get(i);
            }else{
             key+="NA";
            }
        }

        key+="100";
        return key;
    }

    public static void main(String[] args) {
       /*  FiltradorTabla tabla = new FiltradorTabla();
        ArrayCircular<String> filtros = new ArrayCircular<>(2);
        filtros.pushBack("5"); //departamento
        filtros.pushBack("5"); //municipio
        filtros.pushBack("OFICIAL"); //SECTOR
        filtros.pushBack("URBANA"); //ZONA
        filtros.pushBack("100"); //puntaje global

        tabla.get_data_filter(filtros).printList(); */
    }
    
}
