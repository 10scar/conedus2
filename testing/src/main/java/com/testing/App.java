package com.testing;
import com.testing.faker_conedus.FakerConedus;
import com.testing.estructuras.*;
import com.testing.models.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //estructura_1_establecimiento  estructura_2_sedes
        FakerConedus faker_generador =new  FakerConedus();
        Establecimiento establecimiento = faker_generador.establecimiento();
        Sede sede = faker_generador.sedes(establecimiento);
        //estructura_1_establecimiento.pushback(establecimiento);
        //estructura_2_sedes.pushback(sedes);

        //crea 3 icfes y los añade al atributo icfes
        Icfes icfes = faker_generador.sedes(establecimiento);
        sede.setIcfes(icfes);

        System.out.println( "Hello World!" );
        

         /*TO DO
    * loop1 crear lista de establecimientos
    * loop2 crear lista de sedes, esta vez cada establecimiento tiene una sola sede
    * loop3 agregar a cada sede el puntaje de 3 años (2019,2020,2021)
    
    * Revisar método InOrder de la lista circular dinámica:
    * Exception in thread "main" java.lang.IndexOutOfBoundsException
    * at Array.addAfter(Array.java:90)
    * at Array.insertInOrder(Array.java:169)
    * at Main.main(Main.java:4)    
    */
    }
}
