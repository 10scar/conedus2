package com.testing;

import java.util.Random;

import com.testing.estructuras.DoubleLinkedList;

public class Main {
  public static void main(String[] args) {
    startProccess();
  }

  public static void startProccess() {
    // Insertando y a la vez ordenando
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
    int numPruebas = 1000;
    Random random = new Random();
    long startTime = System.nanoTime();
    int randomNumber = random.nextInt(501);
    doubleLinkedList.insertHead(randomNumber);
    for (int i = 0; i < numPruebas; i++) {
      randomNumber = random.nextInt(501);
      doubleLinkedList.insertOrdered(randomNumber);
    }
    long endTime = System.nanoTime();
    doubleLinkedList.display();
    System.out.println("La demora fue de: " + (endTime - startTime) / 1e6 + " ms");

    // Insertando y después ordenando
    DoubleLinkedList segundaDoubleLinkedList = new DoubleLinkedList();
    int secondRandomNumber = random.nextInt(501);

    long startSecondTime = System.nanoTime();
    segundaDoubleLinkedList.insertHead(secondRandomNumber);
    for (int i = 0; i < numPruebas; i++) {
      randomNumber = random.nextInt(501);
      segundaDoubleLinkedList.insertTail(randomNumber);
    }
    segundaDoubleLinkedList.quickSort();
    long endSecondTime = System.nanoTime();
    System.out.println(
        "La demora insertando y luego actualizando fue de: " + (endSecondTime - startSecondTime) / 1e6 + " ms");
  }

}