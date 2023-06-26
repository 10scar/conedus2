package com.conedus.backend.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conedus.backend.estructuras.ArbolAVL;
import com.conedus.backend.estructuras.ArrayCircular;
import com.conedus.backend.models.Establecimiento;
import com.conedus.backend.models.Icfes;
import com.conedus.backend.models.Sede;
import com.conedus.backend.repositories.SedeRepository;
import com.conedus.backend.sede_funtions.FiltradorTabla;
import com.conedus.backend.interfaces.ISedeService;
import com.google.gson.Gson;

@Service
public class SedeService implements ISedeService {

  @Autowired
  SedeRepository repo = new SedeRepository();

  @Override
  public String getSedes() {

    String json = "";
  
    ArbolAVL<Sede> arbol_sedes = get_data();
    List<Sede> fina_arr = arbol_sedes.getObjectsInArray();
    Gson gson = new Gson();
    if (fina_arr.size() > 0) {
      json = gson.toJson(fina_arr);
    }

    // System.out.println(json);
    return json;
    // return repo.getSedes();
  }

  @Override
  public Sede createSede(Sede sede) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createSede'");
  }

  @Override
  public Sede updateSede(Sede sede) {
    return repo.updateSede(sede);
  }

  @Override
  public void deleteSede(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteSede'");
  }

  public ArbolAVL<Sede> get_data() {
    String sql = "SELECT * FROM ouvxvkkq_conedus_pruebas.sedes limit 100";
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

    // Ejecutar la consulta
    Establecimiento default_establecimiento = new Establecimiento(valorColumna1, valorColumna1, valorColumna1,
        valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1,
        valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1,
        valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, null, 0, valorColumna1,
        null);
    List<Map<String, Object>> resultados = repo.queryForList(sql);

    // crear arbol avl con los resultados
    ArbolAVL<Sede> arbol_sedes = new ArbolAVL<>();
    int pro_count = 0;
    // Procesar los resultados
    for (Map<String, Object> fila : resultados) {
      pro_count++;
      // traer datos
      int sede_id = (Integer) fila.get("sede_id");
      ArrayCircular<Icfes> icfes = new ArrayCircular<>(2);
      get_icfes(icfes, sede_id);

      municipioID = Integer.toString((int) fila.get("municipio_id"));
      codigoDane = (String) fila.get("sede_dane");
      nombre = (String) fila.get("sede_nombre");
      zona = (String) fila.get("sede_zona");
      direccion = (String) fila.get("sede_direccion");
      telefono = (String) fila.get("sede_telefono");
      email = (String) fila.get("sede_email");
      sector = (String) fila.get("sede_sector");
      estado = (String) fila.get("sede_estado");
      niveles = new String[0];
      modelos = (String) fila.get("sede_modelos");
      grados = new String[0];
      coordenadas = new ArrayCircular<>(2);

      nueva_sede = new Sede(default_establecimiento, municipioID, codigoDane, nombre, zona, direccion, telefono,
          email, sector, estado, niveles, modelos, grados, coordenadas);
      nueva_sede.setIcfes(icfes);
      arbol_sedes.insertAVL(nueva_sede);
      // Hacer algo con los valores
    }
    return arbol_sedes;
  }

  public void get_icfes(ArrayCircular<Icfes> array, Integer sedes_id) {
    String sql = "SELECT * FROM ouvxvkkq_conedus_pruebas.icfes where sedes_id =" + sedes_id;
    List<Map<String, Object>> resultados = repo.queryForList(sql);
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
      global = (Integer) fila.get("icfes_global");
      matematicas = (Integer) fila.get("icfes_matematicas");
      lectura = (Integer) fila.get("icfes_lectura");
      sociales = (Integer) fila.get("icfes_sociales");
      ciencias = (Integer) fila.get("icfes_ciencias");
      ingles = (Integer) fila.get("icfes_ingles");
      nuevo_icfes = new Icfes(año, global, matematicas, lectura, sociales, ciencias, ingles);
      array.pushBack(nuevo_icfes);
    }
  }

  public String getTOPObjects(){
    String json = "";
        ArbolAVL<Sede> arbol_sedes = get_data();

        // para retornar el json
        List<Sede> fina_arr = arbol_sedes.getTopObjects(10);
        List<Map<String, Object>> json_arr = new ArrayList<>();
        Gson gson = new Gson();
        if (fina_arr.size() > 0) {
            for (Sede sedes : fina_arr) {
                Map<String, Object> props = new HashMap<>();
                props.put("municipio_nombre", sedes.getNombre());
                props.put("promedio", sedes.getPromedioIcfes());
                props.put("establecimiento_nombre", sedes.getNombre());
                props.put("establecimiento_sector", sedes.getSector());
                props.put("establecimiento_genero", "MASCULINO");
                props.put("id", sedes.getCodigoDane());
                json_arr.add(props);
            }
            json = gson.toJson(json_arr);
        }
        return json;
  }

  public String getLists(){
    String json = "";
      ArbolAVL<Sede> arbol_sedes = get_data();

      // para retornar el json
      List<Sede> fina_arr = arbol_sedes.getTopObjects(10);
      List<Map<String, Object>> json_arr = new ArrayList<>();
      Gson gson = new Gson();
      if (fina_arr.size() > 0) {
        for (Sede sedes : fina_arr) {
            Random random = new Random();
            Map<String, Object> props = new HashMap<>();
            props.put("daneSede", sedes.getCodigoDane());
            props.put("nombre", sedes.getNombre());
            props.put("clasificacion", sedes.getDireccion());
            props.put("puntajeGlobal", (int) sedes.getPromedioIcfes());
            props.put("lectura", random.nextInt(501));
            props.put("sociales", random.nextInt(501));
            props.put("ciencias", random.nextInt(501));
            props.put("matematicas", random.nextInt(501));
            props.put("ingles", random.nextInt(501));
            json_arr.add(props);
        }
        json = gson.toJson(json_arr);
    }

    return json;
  }
  
  public String filtro( String departamento,  String municipio, 
   String sector,  String zona, String global ){
    String json = "";
    String sql = "SELECT sed.sede_id, sed.sede_nombre, sed.municipio_id, sed.sede_dane, sed.sede_zona, sed.sede_direccion, sed.sede_telefono, "
        + "sed.sede_email, sed.sede_sector, sed.sede_estado, sed.sede_modelos, mun.departamento_id, "
        + "AVG(Cast(ic.icfes_global as int)) as icfes_global, AVG(ic.icfes_matematicas) as icfes_matematicas, "
        + "AVG(ic.icfes_lectura) as icfes_lectura, AVG(ic.icfes_sociales) as icfes_sociales, "
        + "AVG(ic.icfes_ciencias) as icfes_ciencias, AVG(ic.icfes_ingles) as icfes_ingles "
        + "FROM sedes as sed "
        + "INNER JOIN icfes as ic ON ic.sedes_id = sed.sede_id "
        + "INNER JOIN municipios as mun ON sed.municipio_id = mun.municipio_id "
        + "GROUP BY sede_id;";
    List<Map<String, Object>> resultados = repo.queryForList(sql);
    FiltradorTabla tabla = new FiltradorTabla(resultados);
    ArrayCircular<String> filtros = new ArrayCircular<>(2);
    filtros.pushBack(departamento); // departamento
    filtros.pushBack(municipio); // municipio
    filtros.pushBack(sector); // SECTOR
    filtros.pushBack(zona); // ZONA
    filtros.pushBack(global); // puntaje global
    System.out.println(filtros.stringkey());

    

    List<Sede> datos = tabla.get_data_filter(filtros).arrayList();
    Gson gson = new Gson();
    if (datos.size() > 0) {
      json = gson.toJson(datos);
    }
    return json;
  }
}
