package com.testing;
import com.testing.faker_conedus.FakerConedus;
import com.testing.estructuras.*;
import com.testing.models.*;


import java.util.Scanner;
import java.util.ArrayList;//Reemplaza por Array circular
import java.util.LinkedList;//Reemplaza nuestra estructura
import java.util.Random;//Reemplaza faker
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws FileNotFoundException
    {
        Random rand = new Random();//FakerConedus faker_generador =new FakerConedus();
        ArrayCircular<Integer> arrayCircularSedes = new ArrayCircular<Integer>(10);
        LinkedList<Integer> linkedListSedes = new LinkedList<Integer>();
        // Doubly linked list

        long start;
        long timeCreate;
        long timeOrder;
        long timeRead;
        long timeUpdate;
        long timeDelete;
        
        String tipoEstructura;
        String ordenar;
        int numeroDatos;

        Scanner sc = new Scanner(System.in);
        System.out.println("Prueba de operaciones CRUD en estructuras con datos primitivos");
        System.out.println("Elija tipo de estructura:\n(1) Array Circular\n(2) Lista enlazada sencilla\n(3) Lista enlazada doble");
        tipoEstructura = sc.nextLine();
        System.out.println();

        System.out.println("¿Deseea ordenar los datos a medida que se insertan? (y/n)");
        ordenar = sc.nextLine();
        System.out.println();
        
        System.out.println("¿Cuantos datos desea agregar?"); 
        numeroDatos = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        switch(tipoEstructura){
            case "1":// Array Circular
                // Create 
                if (ordenar.equals("y")){
                    start = System.nanoTime();
                    for (int i = 0; i<numeroDatos; i++){
                        int num = rand.nextInt(numeroDatos);
                        arrayCircularSedes.insertInOrder(num);
                    }
                    timeCreate = (System.nanoTime()-start);
                    timeOrder = 0;
                }else{
                    start = System.nanoTime();
                    for (int i = 0; i<numeroDatos; i++){
                        int num = rand.nextInt(numeroDatos);
                        arrayCircularSedes.pushBack(num);
                    }
                    timeCreate = (System.nanoTime()-start);

                    // Order elements
                    start = System.nanoTime();
                    //arrayCircularSedes.quickOrder()
                    timeOrder = (System.nanoTime()-start);
                }
            break;

            case "2":
            if (ordenar.equals("y")){
                start = System.nanoTime();
                for (int i = 0; i<numeroDatos; i++){
                    int num = rand.nextInt(numeroDatos);
                    linkedListSedes.insertInOrder(num);
                }
                timeCreate = (System.nanoTime()-start);
                timeOrder = 0;
            }else{
                start = System.nanoTime();
                for (int i = 0; i<numeroDatos; i++){
                    int num = rand.nextInt(numeroDatos);
                    linkedListSedes.pushBack(num);
                }
                timeCreate = (System.nanoTime()-start);

                // Order elements
                start = System.nanoTime();
                //arrayCircularSedes.quickOrder()
                timeOrder = (System.nanoTime()-start);
            }
            break;

            case "3":
            break;
        }

            // Prueba 1: agregar datos: create.csv
            long create1;
            long read1;
            long update1;
            long delete1;

            long create2;
            long read2;
            long update2;
            long delete2;
            
            
            long start = System.nanoTime();
            for (int i=0; i<c; i++){
                //metodo agregar en estructura1
                int num = rand.nextInt(c*10);
                arrayCircularSedes.add(num);
                linkedListSedes.add(num);
                
            }
            create1 = (System.nanoTime()-start)/1000;// para tener el tiempo en milisegundos


            start = System.nanoTime();
            for (int i=0; i<c; i++){
                //metodo agregar en estructura2
                int num = rand.nextInt(c*10);
                linkedListSedes.add(num);
            }
            create2 = (System.nanoTime()-start)/1000;// para tener el tiempo en milisegundos

            System.out.printf("%d,%d,%d,\n",c,create1,create2);// y asi con las demas medicionees
        
        

            // Prueba 2: leer top 10 sedes por promedio de icfes: read.csv
            // Prueba 3: Actualizar informacion de una sede: update.csv
            // Prueba 4: Borrar el estudiante con el segundo promedio de icfes mas alto : delete.csv


            // Clear arrays for the next tests
            arrayCircularSedes = new ArrayList<Integer>(10);// arrayCircularSedes = new ArrayCircular(10);
            linkedListSedes = new LinkedList<Integer>();// linkedListSedes = new LinkedList();




        // Establecimiento establecimiento = faker_generador.establecimiento();
        // Sede sede = faker_generador.sedes(establecimiento);
        // //estructura_1_establecimiento.pushback(establecimiento);
        // //estructura_2_sedes.pushback(sedes);

        // //crea 3 icfes y los añade al atributo icfes
        // Icfes icfes = faker_generador.sedes(establecimiento);
        // sede.setIcfes(icfes);

        // System.out.println( "Hello World!" );
        

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



