<<<<<<< Updated upstream
package com.testing;
import com.testing.faker_conedus.FakerConedus;
import com.testing.estructuras.*;
import com.testing.models.*;


import java.util.Scanner;
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

        long start = 0L;
        long timeCreate = 0L;
        long timeOrder = 0L;
        long timeRead = 0L;
        long timeUpdate = 0L;
        long timeDelete = 0L;
        long timeDeleteAll = 0L;
        
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

                //Read: obtener el valor del penultimo elemento en la lista
                start = System.nanoTime();
                arrayCircularSedes.get(arrayCircularSedes.getSize()-2);
                timeRead = (System.nanoTime()-start);

                // Delete: quitar el elemento central (peor caso porque elimina corriendo el extremo mas cerca al indice)
                start = System.nanoTime();
                arrayCircularSedes.get(arrayCircularSedes.getSize()/2);
                timeDelete = (System.nanoTime()-start);

                // Update: el penultimo elemento de la lista
                start = System.nanoTime();
                arrayCircularSedes.set(arrayCircularSedes.getSize()-1,numeroDatos + 5);
                timeUpdate = (System.nanoTime()-start);

                //Delete All
                start = System.nanoTime();
                while(arrayCircularSedes.getSize()>0){
                    arrayCircularSedes.popFront();
                }
                timeDeleteAll = (System.nanoTime()-start);
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

                // Order elements?????????????????????????????????????????????????????????????
                start = System.nanoTime();
                //arrayCircularSedes.quickOrder()???
                timeOrder = (System.nanoTime()-start);
            }
            
            //Read: obtener el valor del penultimo elemento en la lista
            start = System.nanoTime();
            linkedListSedes.get(numeroDatos-2);
            timeRead = (System.nanoTime()-start);

            // Update: cambiar el tercer elemento por 3
            start = System.nanoTime();
            linkedListSedes.getHead().getNext().getNext().setData(numeroDatos + 5);
            timeUpdate = (System.nanoTime()-start);


            // Delete: eliminar el segundo elemento
            start = System.nanoTime();
            try {
                linkedListSedes.delete(rand.nextInt(numeroDatos));
            } catch (Exception e) {
            }
            timeDelete = (System.nanoTime()-start);

            // Delete all
            start = System.nanoTime();
            while(linkedListSedes.getHead()!=null){
                linkedListSedes.popFront();
            }
            timeDeleteAll = (System.nanoTime()-start);
            break;

    
            case "3":
            break;
        }

        System.out.println("RESULTADOS");
        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s\n","Create","Read","Update","Delete","Order","Delete All");
        System.out.printf("%-12d%-12d%-12d%-12d%-12d%-12d\n",timeCreate,timeRead,timeUpdate,timeDelete,timeOrder,timeDeleteAll);


    }
}





=======
package com.testing; //árbol BST

import java.util.Random;

import com.testing.estructuras.ArbolBST;

public class Main {
    public static void main(String[] args) {
        startProcess();
    }

    public static void startProcess() {
        // Insertando y a la vez ordenando
        ArbolBST<Integer> bst = new ArbolBST<>();
        int numPruebas = 1000;
        Random random = new Random();
        long startTime = System.nanoTime();
        int randomNumber = random.nextInt(501);
        bst.insertBST(randomNumber);
        for (int i = 0; i < numPruebas; i++) {
            randomNumber = random.nextInt(501);
            bst.insertBST(randomNumber);
        }
        long endTime = System.nanoTime();
        bst.inOrderBST();
        System.out.println("La demora fue de: " + (endTime - startTime) / 1e6 + " ms");

        // Insertando y después ordenando
        ArbolBST<Integer> segundaBst = new ArbolBST<>();
        int secondRandomNumber = random.nextInt(501);

        long startSecondTime = System.nanoTime();
        segundaBst.insertBST(secondRandomNumber);
        for (int i = 0; i < numPruebas; i++) {
            randomNumber = random.nextInt(501);
            segundaBst.insertBST(randomNumber);
        }
        segundaBst.inOrderBST();
        long endSecondTime = System.nanoTime();
        System.out.println(
                "La demora insertando y luego actualizando fue de: " + (endSecondTime - startSecondTime) / 1e6 + " ms");
    }
}
>>>>>>> Stashed changes
