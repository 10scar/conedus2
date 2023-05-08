package com.testing;
import com.testing.faker_conedus.FakerConedus;
import com.testing.estructuras.*;
import com.testing.models.*;
import java.util.Scanner;


public class TopColegios {

   public static int menu(Scanner sc){
    boolean estado=true;
    int opcion=0;
    int cantidad=0;
    System.out.println("#################################### \nTop 10 Colegios ccon Datos de Prueba \n#################################### \n");     
    System.out.println("(1).Prueba con 10 mil datos \n(2). Prueba con 100 mil datos \n(3). Prueba con 1 millón datos \n(4). Prueba con 10 millones de datos \n(5). Prueba con 100 milones datos \n");

    while(estado){
        opcion = sc.nextInt();
        if(opcion>=1 && opcion <=5){
            estado=false;
        }else{
            System.out.println("Selecione una opción valida");
        }
    }
    switch (opcion) {
        case 1:
            cantidad =10000;
            break;
        case 2:
            cantidad =100000;
            break;
        case 3:
            cantidad =1000000;
            break;
        case 4:
            cantidad =10000000;
            break;
        case 5:
            cantidad =100000000;
            break;
    
        default:
            break;
    }

    return cantidad;
    
}
  public static int menu_estructura(Scanner sc){
    System.out.println("##########################/nSelecione la estructura a usar:");
    System.out.println("(1).Lista enlazada /n(2).Array Circular /n(3).Lista Doblemente Enlazada");
    int opcion = sc.nextInt();
    return opcion;
    }


   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cantidad = menu(sc);
    int opcion_estrutura = menu_estructura(sc);

    switch (opcion_estrutura) {
        case 1:
            lista_enlazada(cantidad);
            break;
            
        case 2:
            array_circular(cantidad);
            break;

        case 3:
            lista_doble(cantidad);
            break;
    
        default:
            System.out.println("Opción en construcción");
            break;
    }
   }

   public static void lista_enlazada(int cantidad){
    FakerConedus generador_conedus = new FakerConedus();
    Establecimiento establecimiento = generador_conedus.establecimiento();
    LinkedList<Sede> lista_sedes = new LinkedList<>();

    //inserta todos los datos de los colegios y los va ordenando de una vez, si el dato no entra en el top lo saca.
    long inicio = System.currentTimeMillis();
        for(int i=0;i<=cantidad;i++){
            Sede colegio = generador_conedus.sedes(establecimiento);
            colegio.setIcfes(generador_conedus.icfes());
            //agrega ordenados de acuerdo a su promedio de icfes
            lista_sedes.insertInOrder(colegio);
            if(lista_sedes.getSize()>=11){
                lista_sedes.popFront();
            }
        }
    long fin = System.currentTimeMillis();
    long tiempoEjecucion = fin - inicio;
    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");
    for(int i =0;i<10;i++){
        Sede colegio =lista_sedes.get(i);
        System.out.println("Promedio Icfes:"+ colegio.getPromedioIcfes()+" "+ colegio.getNombre());
    }
    
}

public static void array_circular(int cantidad){
    FakerConedus generador_conedus = new FakerConedus();
    Establecimiento establecimiento = generador_conedus.establecimiento();
    ArrayCircular<Sede> lista_sedes = new ArrayCircular<>(2);

    //inserta todos los datos de los colegios y los va ordenando de una vez, si el dato no entra en el top lo saca.
    long inicio = System.currentTimeMillis();
        for(int i=0;i<=cantidad;i++){
            Sede colegio = generador_conedus.sedes(establecimiento);
            colegio.setIcfes(generador_conedus.icfes());
            //agrega ordenados de acuerdo a su promedio de icfes
            lista_sedes.insertInOrder(colegio);
            if(lista_sedes.getSize()>=11){
                lista_sedes.popBack();
            }
        }

    long fin = System.currentTimeMillis();
    long tiempoEjecucion = fin - inicio;
    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");
    for(int i=0;i<10;i++){
        Sede colegio =lista_sedes.get(i);
        System.out.println("Promedio Icfes:"+ colegio.getPromedioIcfes()+" "+ colegio.getNombre());
    }

}

public static void lista_doble(int cantidad){
    FakerConedus generador_conedus = new FakerConedus();
    Establecimiento establecimiento = generador_conedus.establecimiento();
    DoublyLinkedListGeneric<Sede> lista_sedes = new DoublyLinkedListGeneric<>();

    //inserta todos los datos de los colegios y los va ordenando de una vez, si el dato no entra en el top lo saca.
    long inicio = System.currentTimeMillis();
        for(int i=0;i<=cantidad;i++){
            Sede colegio = generador_conedus.sedes(establecimiento);
            colegio.setIcfes(generador_conedus.icfes());
            //agrega ordenados de acuerdo a su promedio de icfes
            lista_sedes.insertInOrder(colegio);
            if(lista_sedes.getSize()>=11){
                lista_sedes.popFront();
            }
        }

    long fin = System.currentTimeMillis();
    long tiempoEjecucion = fin - inicio;
    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");
    for(int i=0;i<10;i++){
        Sede colegio =lista_sedes.get(i);
        System.out.println("Promedio Icfes:"+ colegio.getPromedioIcfes()+" "+ colegio.getNombre());
    }

}


}
