package com.testing;
import com.testing.faker_conedus.FakerConedus;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FakerConedus faker_generador =new  FakerConedus();
        faker_generador.establecimiento();
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
