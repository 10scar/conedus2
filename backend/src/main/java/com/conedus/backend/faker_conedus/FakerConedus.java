package com.conedus.backend.faker_conedus;
import java.lang.reflect.Array;
import java.util.Locale;
import java.util.Random;
import com.github.javafaker.Faker;
import com.conedus.backend.models.Establecimiento;
import com.conedus.backend.models.Sede;
import com.conedus.backend.models.Icfes;

import com.conedus.backend.estructuras.LinkedList;
import com.conedus.backend.estructuras.ArrayCircular;;

public class FakerConedus {
    private static Faker faker;
    private static Random random;



    public FakerConedus(){
        faker = new Faker(new Locale("es-MX"));
        random = new Random();
    }

    public String getRandomElement(String[] opciones){
        return opciones[new Random().nextInt(opciones.length)];
    }

    public Establecimiento establecimiento(){
        
        String[] prestadorPlantaOptions = {"OFICIAL", "PERSONA NATURAL", "FUNDACION O CORPORACIONES", "COMUNIDAD RELIGIOSA",
                "SOCIEDAD", "EDUCACION MISIONAL CONTRATADA", "FEDERACIONES", "COOPERATIVO", "CAJA DE COMPENSACIÓN",
                "CONCESION", "REGIMEN ESPECIAL", "COMUNIDAD", "UNIVERSIDAD"};  
        String[] municipios = {"Bogota", "Medellin", "Cartagena"};
        String municipio_id = municipios[new Random().nextInt(municipios.length)];
        String nombre = faker.company().name();
        String dane = faker.numerify("###########");
        String correo = faker.internet().emailAddress();
        String direccion = faker.address().fullAddress();
        String telefono = faker.phoneNumber().phoneNumber();
        String rector = faker.name().fullName();
        String tipo = getRandomElement(new String[]{"INSTITUCION EDUCATIVA", "CENTRO EDUCATIVO"});
        String etnias = getRandomElement(new String[]{"Ninguna", "Afrocolombiana", "Indígena", "Rom", "Palenquera"});
        String sector = getRandomElement(new String[]{"OFICIAL", "NO OFICIAL"});
        String genero = getRandomElement(new String[]{"MASCULINO", "FEMENINO", "MIXTO"});
        String jornadas = getRandomElement(new String[]{"Mañana", "Tarde", "Noche", "Mañana y tarde", "Tarde y noche", "Jornada continua"});
        String calendario = getRandomElement(new String[]{"A", "B"});
        String caracter = getRandomElement(new String[]{"Académico", "Técnico", "Tecnológico", "Académico-Técnico", "Académico-Tecnológico"});
        String licencia = getRandomElement(new String[]{"SIN REVISAR", "CONDICIONAL", "DEFINITIVA", "RECONOCIMIENTO OFICIAL", "REVISADA ACEPTADA", "REVISADA NO ACEPTADA"});
        String modelos = getRandomElement(new String[]{"Educación para el trabajo y el desarrollo humano", "Escuela nueva", "Escuela tradicional", "Escuela activa"});
        String capacidadesExcepcionales = getRandomElement(new String[]{"Sí", "No"});
        String discapacidades = faker.lorem().word();
        String idiomas = faker.lorem().word();
        String estado = getRandomElement(new String[]{"NUEVO-ACTIVO", "ANTIGUO-ACTIVO", "CIERRE DEFINITIVO", "CIERRE TEMPORAL"});
        String prestador_servicio = getRandomElement(new String[]{"OFICIAL", "PERSONA NATURAL", "FUNDACION O CORPORACIONES", "COMUNIDAD RELIGIOSA", "SOCIEDAD", "EDUCACION MISIONAL CONTRATADA", "FEDERACIONES", "COOPERATIVO", "CAJA DE COMPENSACIÓN", "CONCESION", "REGIMEN ESPECIAL", "COMUNIDAD", "UNIVERSIDAD"});
        String prestador_planta = prestadorPlantaOptions[random.nextInt(prestadorPlantaOptions.length)];
        String resguardo = faker.address().fullAddress();
        int matricula_contratada = random.nextInt(2);
        String internado = faker.lorem().word();
        ArrayCircular<Double> coordenadas = new ArrayCircular<>(2);
        coordenadas.pushBack(Double.parseDouble(faker.address().latitude().replace(",", ".")));
        coordenadas.pushBack(Double.parseDouble(faker.address().longitude().replace(",", ".")));

        //"Object establecimiento = new Object();
        Establecimiento establecimiento = new Establecimiento(municipio_id,nombre,dane,direccion,telefono,correo,rector,tipo,jornadas,etnias,sector,genero,caracter,licencia,modelos,capacidadesExcepcionales,discapacidades,idiomas,estado,prestador_servicio,calendario, prestador_planta,resguardo,matricula_contratada,internado,coordenadas);
        //la idea es retornar un objeto de tipo establecimiento. 
        return establecimiento;
    }

    
    public Sede sedes(Establecimiento establecimiento_ref) {
        // Generar datos aleatorios para cada campo
        String[] municipios = { "Bogota", "Medellin", "Cartagena" };
        String municipio_id = municipios[random.nextInt(municipios.length)];
        Establecimiento establecimiento_id = establecimiento_ref;
        String dane = faker.regexify("###########");
        String nombre = faker.company().name();
        String zona = random.nextBoolean() ? "URBANA" : "RURAL";
        String direccion = faker.address().fullAddress();
        String telefono = faker.phoneNumber().phoneNumber();
        String email = faker.internet().emailAddress();
        String sector = random.nextBoolean() ? "OFICIAL" : "NO OFICIAL";
        String estado = random.nextBoolean() ? "NUEVO-ACTIVO" : "ANTIGUO-ACTIVO";
        String[] niveles = { "PREESCOLAR", "MEDIA", "BÁSICA SECUNDARIA", "BÁSICA PRIMARIA" };
        String modelos = faker.options().option("Educación para el trabajo y el desarrollo humano",
                "Escuela nueva", "Escuela tradicional", "Escuela activa");
        String[] grados = { "TRANSFORMEMOS", "PROGRAMA PARA JÓVENES EN EXTRAEDAD Y ADULTOS", "UNAD", "A CRECER",
                "ACELERACIÓN DEL APRENDIZAJE", "EDUCACIÓN TRADICIONAL" };
        ArrayCircular<Double> coordenadas = new ArrayCircular<>(2);
        coordenadas.pushBack(Double.parseDouble(faker.address().latitude().replace(",", ".")));
        coordenadas.pushBack(Double.parseDouble(faker.address().longitude().replace(",", ".")));

        // Realizar cualquier operación adicional que necesites con los datos generados

        // Retornar true si la generación fue exitosa
        Sede sede = new Sede(establecimiento_id, municipio_id, dane, nombre, zona, direccion, telefono, email, sector, estado, niveles, modelos, grados, coordenadas);
        return sede;
    }



    public ArrayCircular<Icfes> icfes() {

        ArrayCircular<Icfes> lista_icfes = new ArrayCircular<>(2);
        int icfes_año = 2019;
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int icfes_global = random.nextInt(500) + 1;
            int icfes_matematicas = random.nextInt(100) + 1;
            int icfes_lectura = random.nextInt(100) + 1;
            int icfes_sociales = random.nextInt(100) + 1;
            int icfes_ciencias = random.nextInt(100) + 1;
            int icfes_ingles = random.nextInt(100) + 1;
            icfes_año++;

            Icfes icfesResult = new Icfes(icfes_año,icfes_global, icfes_matematicas,
                    icfes_lectura, icfes_sociales, icfes_ciencias, icfes_ingles);

            lista_icfes.pushBack(icfesResult); 
        }
        return lista_icfes;
}

}
