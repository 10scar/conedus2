package com.conedus.backend.sede_funtions;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conedus.backend.estructuras.ArbolAVL;
import com.conedus.backend.estructuras.ArrayCircular;
import com.conedus.backend.models.Establecimiento;
import com.conedus.backend.models.Icfes;
import com.conedus.backend.models.Sede;

public class GetData {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public ArbolAVL<Sede> get_data() {
        String sql = "SELECT * FROM ouvxvkkq_conedus_pruebas.sedes limit 10";
        String valorColumna1 = "nada";

        Sede nueva_sede;
        ArrayCircular<Icfes> icfes;
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
        float promedio_icfes;

        // Ejecutar la consulta
        Establecimiento default_establecimiento = new Establecimiento(valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, sql, 0, valorColumna1, null);
        List<Map<String, Object>> resultados = jdbcTemplate.queryForList(sql);

        //crear arbol avl con los resultados
        ArbolAVL<Sede> arbol_sedes = new ArbolAVL<>();

        // Procesar los resultados
        for (Map<String, Object> fila : resultados) {
    
            //traer datos
            icfes = new ArrayCircular<>(2);
            municipioID= (String) fila.get("municipio_id");
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
            promedio_icfes= (Float) fila.get("sede_estado");;

            nueva_sede = new Sede(default_establecimiento, municipioID, codigoDane, nombre, zona, direccion, telefono, email, sector, estado, niveles, modelos, grados, coordenadas);    
            arbol_sedes.insertAVL(nueva_sede);
            // Hacer algo con los valores
        }
        return arbol_sedes;
    }
    public static void main(String[] args) {
       
    }
}
