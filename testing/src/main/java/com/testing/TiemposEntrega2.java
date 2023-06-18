package com.testing;
import com.testing.faker_conedus.FakerConedus;
import com.testing.estructuras.*;
import com.testing.models.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TiemposEntrega2 {
    private class Node {
        private Node left;
        private Sede data;
        private Node right;

        public Node() {
            this(null);
        }

        public Node(Sede data) {
            left = null;
            this.data = data;
            right = null;
        }
    }

    public static int menu(Scanner sc) {
        boolean estado = true;
        int opcion = 0;
        int cantidad = 0;
        System.out.println(
                "#################################### \nTiempo de ejecución de funcionalidades con Datos de Prueba \n#################################### \n");
        System.out.println(
                "(1). Prueba con 1000 datos \n(2). Prueba con 10 mil datos \n(3). Prueba con 100 mil datos \n(4). Prueba con 1 millón datos \n(5). Prueba con 10 millones de datos \n(6). Prueba con 100 milones datos \n(7). Prueba con 100 datos \n(8). Prueba con 10 datos \n(9). Prueba con 1 dato\n");

        while (estado) {
            opcion = sc.nextInt();
            if (opcion >= 1 && opcion <= 9) {
                estado = false;
            } else {
                System.out.println("Seleccione una opción válida");
            }
        }
        switch (opcion) {
            case 1:
                cantidad = 1000;
                break;
            case 2:
                cantidad = 10000;
                break;
            case 3:
                cantidad = 100000;
                break;
            case 4:
                cantidad = 1000000;
                break;
            case 5:
                cantidad = 10000000;
                break;
            case 6:
                cantidad = 100000000;
                break;
            case 7:
                cantidad = 100;
                break;
            case 8:
                cantidad = 10;
                break;
            case 9:
                cantidad = 1;
                break;
            default:
                break;
        }

        return cantidad;
    }

    public static int menuEstructura(Scanner sc) {
        System.out.println("##########################\nSeleccione la estructura a usar:");
        System.out.println("(1). BST \n(2). AVL");
        int opcion = sc.nextInt();
        return opcion;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> tiempos = new ArrayList<>(5);
        int cantidad = menu(sc);
        int opcionEstructura = menuEstructura(sc);

        switch (opcionEstructura) {
            case 1:
                tiempos = bst(cantidad);
                break;
            case 2:
                tiempos = avl(cantidad);
                break;
            default:
                System.out.println("Opción en construcción");
                break;
        }

        System.out.println("RESULTADOS (Nanosegundos)");
        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Insert N", "Insert 1", "Update(?)", "Delete 1", "getTop10");
        System.out.printf("%-25d%-25d%-25d%-25d%-25d\n", tiempos.get(0), tiempos.get(1), tiempos.get(2),
                tiempos.get(3), tiempos.get(4));
    }

    public static ArrayList<Long> bst(int cantidad) {
        FakerConedus generadorConedus = new FakerConedus();
        Establecimiento establecimiento = generadorConedus.establecimiento();
        ArbolBST<Sede> bstSedes = new ArbolBST<>();

        Sede dataExample = generadorConedus.sedes(establecimiento);// Sobre este se probarán las tres funcionalidades
                                                                   // siguientes
        ArrayList<Long> tiempos = new ArrayList<>(5);// [insert n, insert 1, update 1, remove 1, getTop10]
        Long startTime;

        // Create
        startTime = System.nanoTime();
        for (int i = 0; i < cantidad; i++) {
            Sede colegio = generadorConedus.sedes(establecimiento);
            colegio.setIcfes(generadorConedus.icfes());
            // agrega ordenados de acuerdo a su promedio de icfes
            bstSedes.insertBST(colegio);
        }
        tiempos.add(System.nanoTime() - startTime);// insert n

        // Se inserta al final para obtener el tiempo individual de inserción ya con n
        // elementos en el árbol
        startTime = System.nanoTime();
        bstSedes.insertBST(dataExample);
        tiempos.add(System.nanoTime() - startTime);// insert 1

        // Update
        tiempos.add(0L);

        // Delete
        startTime = System.nanoTime();
        bstSedes.removeBST(dataExample);
        tiempos.add(System.nanoTime() - startTime);// remove 1

        // Top10
        startTime = System.nanoTime();
        System.out.println("\nNodos del top 10:");
        bstSedes.printTopBST(10);
        System.out.println();
        tiempos.add(System.nanoTime() - startTime);// getTop10

        return tiempos;
    }

    public static ArrayList<Long> avl(int cantidad) {
        FakerConedus generadorConedus = new FakerConedus();
        Establecimiento establecimiento = generadorConedus.establecimiento();
        ArbolAVL<Sede> avlSedes = new ArbolAVL<>();

        Sede dataExample = generadorConedus.sedes(establecimiento);// Sobre este se probarán las tres funcionalidades
                                                                   // siguientes
        ArrayList<Long> tiempos = new ArrayList<>(5);// [insert n, insert 1, update 1, remove 1, getTop10]
        Long startTime;

        // Create
        startTime = System.nanoTime();
        for (int i = 0; i < cantidad; i++) {
            Sede colegio = generadorConedus.sedes(establecimiento);
            colegio.setIcfes(generadorConedus.icfes());
            // agrega ordenados de acuerdo a su promedio de icfes
            avlSedes.insertAVL(colegio);
        }
        tiempos.add(System.nanoTime() - startTime);// insert n

        // Se inserta al final para obtener el tiempo individual de inserción ya con n
        // elementos en el árbol
        startTime = System.nanoTime();
        avlSedes.insertAVL(dataExample);
        tiempos.add(System.nanoTime() - startTime);// insert 1

        // Update
        tiempos.add(0L);

        // Delete
        startTime = System.nanoTime();
        avlSedes.removeAVL(dataExample);
        tiempos.add(System.nanoTime() - startTime);// remove 1

        // Top10
        startTime = System.nanoTime();
        System.out.println("\nNodos del top 10:");
        avlSedes.printTopAVL(10);
        System.out.println();
        tiempos.add(System.nanoTime() - startTime);// getTop10

        return tiempos;
    }
}
