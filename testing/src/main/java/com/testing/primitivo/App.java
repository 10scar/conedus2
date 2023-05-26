package com.testing;

import java.util.Random;

//import com.testing.estructuras.ArbolBST;
//*
public class ArbolBST<T extends Comparable<T>> {
    private Node root;
    private int count = 0;// printTop(n)

    public ArbolBST() {
        root = null;
    }

    public void insertBST(T data) {
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
        return p;
    }

    public void removeBST(T data) {
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
                    Node t = findMin(p.right);
                    p.data = t.data;
                    p.right = remove(p.data, p.right);
                }
            }
        } else {
            System.out.println("Item no está en el árbol");
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

    public void inOrderBST() {
        System.out.print("Recorrido en inorden::");
        if (root != null)
            inOrder(root);
        else
            System.out.print(" " + "Vacio");
        System.out.println();
    }

    public void preOrderBST() {
        System.out.print("Recorrido en preorden:");
        if (root != null)
            preOrder(root);
        else
            System.out.print(" " + "Vacio");
        System.out.println();
    }

    public void postOrderBST() {
        System.out.print("Recorrido en postorden:");
        if (root != null)
            postOrder(root);
        else
            System.out.print(" " + "Vacio");
        System.out.println();
    }

    private void inOrder(Node ptr) {
        if (ptr.left != null)
            inOrder(ptr.left);
        System.out.print(" " + ptr.data);
        if (ptr.right != null)
            inOrder(ptr.right);
    }

    private void preOrder(Node ptr) {
        System.out.print(" " + ptr.data);
        if (ptr.left != null)
            preOrder(ptr.left);
        if (ptr.right != null)
            preOrder(ptr.right);
    }

    private void postOrder(Node ptr) {
        if (ptr.left != null)
            postOrder(ptr.left);
        if (ptr.right != null)
            postOrder(ptr.right);
        System.out.print(" " + ptr.data);
    }

    public void printTopBST(int n) {
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

        public Node() {
            this(null);
        }

        public Node(T data) {
            left = null;
            this.data = data;
            right = null;
        }
    }
}

// *
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
