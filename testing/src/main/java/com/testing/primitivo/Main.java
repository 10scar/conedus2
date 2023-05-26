<<<<<<< Updated upstream
package com.testing;

import java.util.Random;

import com.testing.estructuras.DoubleLinkedList;

=======
package com.testing; //Árbol AVL

import java.util.Random;

import com.testing.estructuras.ArbolAVL;
import java.util.*;

//código del ÁrbolAVL
//de conedus/testing/src/main/java/com/testing/estructuras/ArbolAVL.java
public class ArbolAVL<T extends Comparable<T>> {
  private Node root;
  private int count = 0;// printTop(n)

  public ArbolAVL() {
    root = null;
  }

  public void insertAVL(T data) {
    root = insert(data, root);
  }

  private Node insert(T data, Node p) {
    if (p == null) {
      p = new Node(data);
    } else {
      if (data.compareTo(p.data) < 0) {
        p.left = insert(data, p.left);
      } else if (data.compareTo(p.data) > 0) {
        p.right = insert(data, p.right);
      } else {
        System.out.println("Item no insertado");
      }
    }

    // Actualizar la altura del nodo
    p.height = 1 + Math.max(height(p.left), height(p.right));

    p = balance(p);

    return p;
  }

  public void removeAVL(T data) {
    root = remove(data, root);
  }

  private Node remove(T data, Node p) {
    if (p != null) {
      if (data.compareTo(p.data) < 0) {
        p.left = remove(data, p.left);
      } else if (data.compareTo(p.data) > 0) {
        p.right = remove(data, p.right);
      } else {
        if (p.left == null && p.right == null) {
          p = null;
        } else if (p.left == null) {
          p = p.right;
        } else if (p.right == null) {
          p = p.left;
        } else {
          Node t = findSuccessor(p);
          p.data = t.data;
          p.right = remove(p.data, p.right);
        }
      }

      // Actualizar la altura del nodo
      if (p != null) {
        p.height = 1 + Math.max(height(p.left), height(p.right));

        // Realizar el equilibrado AVL
        p = balance(p);
      }
    } else {
      System.out.println("Item no está en el árbol");
    }
    return p;
  }

  private Node balance(Node p) {
    int balance = getBalance(p);
    if (balance > 1) {
      if (getBalance(p.left) >= 0) {
        p = rotateRight(p);
      } else {
        p.left = rotateLeft(p.left);
        p = rotateRight(p);
      }
    } else if (balance < -1) {
      if (getBalance(p.right) <= 0) {
        p = rotateLeft(p);
      } else {
        p.right = rotateRight(p.right);
        p = rotateLeft(p);
      }
    }
    return p;
  }

  private Node findMin(Node p) {
    if (p != null) {
      while (p.left != null)
        p = p.left;
    }
    return p;
  }

  private Node findSuccessor(Node node) {
    if (node == null) {
      return null;
    }

    if (node.right != null) {
      // Caso 1: Si el nodo tiene un subárbol derecho, el sucesor es el nodo más a la
      // izquierda del subárbol derecho
      return findMin(node.right);
    } else {
      // Caso 2: Si el nodo no tiene un subárbol derecho, el sucesor es el primer
      // ancestro mayor
      Node successor = null;
      Node current = root;

      while (current != null) {
        if (node.data.compareTo(current.data) < 0) {
          successor = current;
          current = current.left;
        } else if (node.data.compareTo(current.data) > 0) {
          current = current.right;
        } else {
          break; // Encontramos el nodo actual, salimos del bucle
        }
      }

      return successor;
    }
  }

  private int height(Node p) {
    if (p == null) {
      return 0;
    }
    return p.height;
  }

  private int getBalance(Node p) {
    if (p == null) {
      return 0;
    }
    return height(p.left) - height(p.right);
  }

  private Node rotateLeft(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // Realizar la rotación
    y.left = x;
    x.right = T2;

    // Actualizar las alturas
    x.height = 1 + Math.max(height(x.left), height(x.right));
    y.height = 1 + Math.max(height(y.left), height(y.right));

    return y;
  }

  private Node rotateRight(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    // Realizar la rotación
    x.right = y;
    y.left = T2;

    // Actualizar las alturas
    y.height = 1 + Math.max(height(y.left), height(y.right));
    x.height = 1 + Math.max(height(x.left), height(x.right));

    return x;
  }

  public int distanciaEntreNodos(T a, T b) {
    T temp;
    if (a.compareTo(b) > 0) {
      temp = a;
      a = b;
      b = temp;
    }
    return rangoNodos(root, a, b);
  }

  public int rangoRoot(Node root, T x) {
    if (root.data.equals(x)) {
      return 0;
    } else if (root.data.compareTo(x) > 0) {
      return 1 + rangoRoot(root.left, x);
    }
    return 1 + rangoRoot(root.right, x);
  }

  public int rangoNodos(Node root, T a, T b) {
    if (root == null) {
      return 0;
    }

    // Descender por la izquierda
    if (root.data.compareTo(a) > 0 && root.data.compareTo(b) > 0)
      return rangoNodos(root.left, a, b);

    // Descender por la derecha
    if (root.data.compareTo(a) < 0 && root.data.compareTo(b) < 0)
      return rangoNodos(root.right, a, b);

    // Encontró la bifurcación y calcula la distancia hasta cada nodo desde la raíz
    // dada
    if (root.data.compareTo(a) >= 0 && root.data.compareTo(b) <= 0)
      return rangoRoot(root, a) + rangoRoot(root, b);

    return 0;
  }

  public void inOrderAVL() {
    System.out.print("Recorrido en inorden::");
    if (root != null)
      inOrder(root);
    else
      System.out.print(" " + "Vacio");
    System.out.println();
  }

  public void preOrderAVL() {
    System.out.print("Recorrido en preorden:");
    if (root != null)
      preOrder(root);
    else
      System.out.print(" " + "Vacio");
    System.out.println();
  }

  public void postOrderAVL() {
    System.out.print("Recorrido en postorden:");
    if (root != null)
      postOrder(root);
    else
      System.out.print(" " + "Vacio");
    System.out.println();
  }

  private void inOrder(Node p) {
    if (!(p.left == null || p.right == null)) {
      inOrder(p.left);
      System.out.print(" " + p.data);
      inOrder(p.right);

    } else
      System.out.print(" " + p.data);
  }

  private void preOrder(Node ptr) {
    System.out.print(" " + ptr.data);
    if (ptr.left != null && ptr.right != null) {
      preOrder(ptr.left);
      preOrder(ptr.right);
    }
  }

  private void postOrder(Node ptr) {
    if (ptr.left != null)
      postOrder(ptr.left);
    if (ptr.right != null)
      postOrder(ptr.right);
    System.out.print(" " + ptr.data);
  }

  public void printTopAVL(int n) {
    count = 1;
    printTop(root, n);
  }

  private Node printTop(Node ptr, int n) {// n es la cantidad de elementos que compone el top
    if (ptr == null) {// caso base
      return null;
    }
    // Buscar en el sub arbol derecho
    Node right = printTop(ptr.right, n);

    if (right != null) {
      return right;
    }
    if (count > n) {
      return ptr;// deja de buscar
    }
    // estan en el top
    else if (count <= n) {
      System.out.println(ptr.data);
    }

    count++;

    // Buscar en el sub arbol izquierdo
    return printTop(ptr.left, n);
  }

  // Inner Class: Node
  private class Node {
    private Node left;
    private T data;
    private Node right;
    private int height;

    public Node(T data) {
      left = null;
      this.data = data;
      right = null;
    }
  }
}

// main
>>>>>>> Stashed changes
public class Main {
  public static void main(String[] args) {
    startProccess();
  }

<<<<<<< Updated upstream
  public static void startProccess(){
    // Insertando y a la vez ordenando
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
=======
  public static void startProccess() {
    // Insertando y a la vez ordenando
    ArbolAVL<Integer> arbol = new ArbolAVL<>();
>>>>>>> Stashed changes
    int numPruebas = 1000;
    Random random = new Random();
    long startTime = System.nanoTime();
    int randomNumber = random.nextInt(501);
<<<<<<< Updated upstream
    doubleLinkedList.insertHead(randomNumber);
    for(int i = 0; i < numPruebas; i++){
      randomNumber = random.nextInt(501);
      doubleLinkedList.insertOrdered(randomNumber);
    }
    long endTime = System.nanoTime();
    doubleLinkedList.display();
    System.out.println("La demora fue de: " + (endTime - startTime)/1e6 + " ms");

    // Insertando y después ordenando
    DoubleLinkedList segundaDoubleLinkedList = new DoubleLinkedList();
    int secondRandomNumber = random.nextInt(501);

    long startSecondTime = System.nanoTime();
    segundaDoubleLinkedList.insertHead(secondRandomNumber);
    for(int i = 0; i < numPruebas; i++){
      randomNumber = random.nextInt(501);
      segundaDoubleLinkedList.insertTail(randomNumber);
    }
    segundaDoubleLinkedList.quickSort();
    long endSecondTime = System.nanoTime();
    System.out.println("La demora insertando y luego actualizando fue de: " + (endSecondTime - startSecondTime)/1e6 + " ms");
  }

  
}
=======
    arbol.insertAVL(randomNumber);
    for (int i = 0; i < numPruebas; i++) {
      randomNumber = random.nextInt(501);
      arbol.insertAVL(randomNumber);
    }
    long endTime = System.nanoTime();
    arbol.inOrderAVL();
    System.out.println("La demora fue de: " + (endTime - startTime) / 1e6 + " ms");

    // Insertando y después ordenando
    ArbolAVL<Integer> segundoArbol = new ArbolAVL<>();
    int secondRandomNumber = random.nextInt(501);

    long startSecondTime = System.nanoTime();
    segundoArbol.insertAVL(secondRandomNumber);
    for (int i = 0; i < numPruebas; i++) {
      randomNumber = random.nextInt(501);
      segundoArbol.insertAVL(randomNumber);
    }
    segundoArbol.inOrderAVL();
    long endSecondTime = System.nanoTime();
    System.out.println(
        "La demora insertando y luego actualizando fue de: " + (endSecondTime - startSecondTime) / 1e6 + " ms");
  }
}
>>>>>>> Stashed changes
