package com.testing.primitivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.testing.estructuras.ArbolBST;

public class App {
    public static void main(String[] args) {
        startProcess();
    }

    public static void startProcess() {
        // Insertando y a la vez ordenando
        ArbolBST<Integer> bst = new ArbolBST<>();

        int numPruebas = 1000;
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i <= numPruebas; i++) {
            numeros.add(i);
        }
    

        long startTime = System.nanoTime();
     
   
        for (int i = 0; i < numPruebas; i++) {
            int valorand = pickRandomNumbers(numeros);
            bst.insertBST(valorand);
        }
        long endTime = System.nanoTime();
        bst.inOrderBST();
        System.out.println("La demora fue de: " + (endTime - startTime) / 1e6 + " ms");

        
    }


    private static int pickRandomNumbers(List<Integer> numeros) {
            int numeroAleatorio = pickRandomNumber(numeros);
            
            numeros.remove(Integer.valueOf(numeroAleatorio));
            return numeroAleatorio;

    }
    
    private static int pickRandomNumber(List<Integer> numeros) {
        Random random = new Random();
        int index = random.nextInt(numeros.size());
        return numeros.get(index);
    }
}
