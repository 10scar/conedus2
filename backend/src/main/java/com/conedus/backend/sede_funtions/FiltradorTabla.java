package com.conedus.backend.sede_funtions;

import java.math.BigDecimal;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conedus.backend.estructuras.*;
import com.conedus.backend.models.Establecimiento;
import com.conedus.backend.models.Icfes;
import com.conedus.backend.models.Sede;
import com.conedus.backend.repositories.SedeRepository;

public class FiltradorTabla {

    //crea una tabla hash vacia por defecto al creaar el objeto filtro
    public HashTable<String,Sede> hash_colegios; 
    List<Map<String, Object>> resultados;
    public FiltradorTabla(List<Map<String, Object>> datos){
        resultados = datos;
        hash_colegios = new HashTable<>();
    }

    public com.conedus.backend.estructuras.LinkedList get_data_filter(ArrayCircular<String> filtros) {

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
         // key para hashtable
        int filtro_global = Integer.valueOf(filtros.get(4));

        // Ejecutar la consulta
        Establecimiento default_establecimiento = new Establecimiento(valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, null, 0, valorColumna1, null);
        
   
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
            modelos= (String) fila.get("sede_modelos");
            grados=new String[0];
            BigDecimal bigDecimalValue = (BigDecimal) fila.get("icfes_global");
            promedio_icfes =  bigDecimalValue.floatValue();
            coordenadas= new ArrayCircular<>(2);

            //datos para el filtro
            datos_colegio.pushBack(municipioID);
            datos_colegio.pushBack(municipioID);
            datos_colegio.pushBack(sector);
            datos_colegio.pushBack(zona);
            

            nueva_sede = new Sede(default_establecimiento, municipioID, codigoDane, nombre, zona, direccion, telefono, email, sector, estado, niveles, modelos, grados, coordenadas);    
            //nueva_sede.setIcfes(icfes);
            nueva_sede.setPromedioIcfes(promedio_icfes);

            
            String key = key_filter(filtros,datos_colegio);
        
            if((nueva_sede.getPromedioIcfes()>= filtro_global || filtro_global==0) &&key.equals(filtros.stringkey())){ 
                hash_colegios.add(key, nueva_sede);
            }
            
            
            
        }
       
        return hash_colegios.getChainWithKey(filtros.stringkey());
    }

    public String key_filter(ArrayCircular<String> filtros, ArrayCircular<String> datos){
        String key = "";
        //recorrem,os las opciones del filtro menos la de academico y si esta agregamos al string la opcion si no dejamos como NA
        for(int i = 0;i< filtros.getSize()-1;i++){
            if(!filtros.get(i).equals("NA")){
            key+=datos.get(i);
            }else{
             key+="NA";
            }
        }

        //key+=filtros.get(4);
        return key;
    }

    public static void main(String[] args) {
    /* FiltradorTabla tabla = new FiltradorTabla();
    ArrayCircular<String> filtros = new ArrayCircular<>(2);
    filtros.pushBack("5"); // departamento
    filtros.pushBack("5"); // municipio
    filtros.pushBack("OFICIAL"); // SECTOR
    filtros.pushBack("URBANA"); // ZONA
    filtros.pushBack("100"); // puntaje global
    System.out.println(filtros.stringkey());

    tabla.get_data_filter(filtros).printList(); */
    }
    
}
