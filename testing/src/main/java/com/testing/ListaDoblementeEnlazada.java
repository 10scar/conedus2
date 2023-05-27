package com.testing;

import java.util.Random;

import com.testing.estructuras.DoubleLinkedList;

public class ListaDoblementeEnlazada {
  public static void main(String[] args) {
    startProccess();
  }

  public static void startProccess(){
    // General
    int numPruebas = 100000;
    Random random = new Random();

    // Insertando
    DoubleLinkedList doubleLinkedListInsert = new DoubleLinkedList();
    long startTimeInsert = System.nanoTime();
    int randomNumber2 = random.nextInt(501);
    doubleLinkedListInsert.insertHead(randomNumber2);
    for(int i = 0; i < numPruebas; i++){
      randomNumber2 = random.nextInt(501);
      doubleLinkedListInsert.insertTail(randomNumber2);
    }
    long endTimeInsert = System.nanoTime();
    System.out.println("La demora de solo insertar fue de: " + ((endTimeInsert - startTimeInsert)/1e6 + " ms"));

    // Eliminando
    long startTimeDelete = System.nanoTime();
    for(int i = 0; i < numPruebas; i++){
      doubleLinkedListInsert.deleteTail();
    }
    long endTimeDelete = System.nanoTime();
    System.out.println("La demora de eliminar toda la lista fue de: " + ((endTimeDelete - startTimeDelete)/1e6 + " ms"));

    // Insertando y a la vez ordenando
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
    long startTimeInsertOrder = System.nanoTime();
    int randomNumber = random.nextInt(501);
    doubleLinkedList.insertHead(randomNumber);
    for(int i = 0; i < numPruebas; i++){
      randomNumber = random.nextInt(501);
      doubleLinkedList.insertOrdered(randomNumber);
    }
    long endTimeInsertOrder = System.nanoTime();
    System.out.println("La demora de insertar ordenando fue de: " + (endTimeInsertOrder - startTimeInsertOrder)/1e6 + " ms");

    // Eliminando un elemento en particular
    long startTimeDeleteOne = System.nanoTime();
    doubleLinkedList.delete(453);
    long endTimeDeleteOne = System.nanoTime();
    System.out.println("La demora de eliminar un elemento en particular fue de: " + (endTimeDeleteOne - startTimeDeleteOne)/1e6 + " ms");

  }
}