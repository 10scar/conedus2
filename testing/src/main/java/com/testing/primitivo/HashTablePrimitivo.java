package com.testing.primitivo;

import java.util.Scanner;
import java.util.*;

public class HashTablePrimitivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de datos:");
        int numeroDatos = sc.nextInt();

        HashTable<Integer, String> hashTable = new HashTable<>();

        // INSERTAR N
        long start = System.nanoTime();
        for (int i = 0; i < numeroDatos; i++) {
            hashTable.add(i, "Valor" + i);
        }
        long timeInsertN = System.nanoTime() - start;

        // INSERTAR 1
        start = System.nanoTime();
        hashTable.add(numeroDatos, "NuevoValor");
        long timeInsert1 = System.nanoTime() - start;

        // ELIMINAR 1
        start = System.nanoTime();
        hashTable.remove(numeroDatos);
        long timeDelete1 = System.nanoTime() - start;

        // getChainWithKey
        start = System.nanoTime();
        LinkedList<String> chain = hashTable.getChainWithKey(numeroDatos - 1);
        long timeGetChain = System.nanoTime() - start;

        System.out.println("Tiempos de ejecución (en nanosegundos):");
        System.out.println("INSERTAR N: " + timeInsertN);
        System.out.println("INSERTAR 1: " + timeInsert1);
        System.out.println("ELIMINAR 1: " + timeDelete1);
        System.out.println("getChainWithKey: " + timeGetChain);
    }
}

// la estructura, disponible en
// https://github.com/10scar/conedus/blob/backend/testing/src/main/java/com/testing/estructuras/HashTable.java
class HashTable<K extends Comparable<K>, V extends Comparable<V>> {

    private class htNode<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<htNode<K, V>> {
        K key;
        V value;
        htNode<K, V> next;

        public htNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int compareTo(htNode<K, V> obj) {
            return key.compareTo(obj.key);
        }
    }

    private int size;
    private int capacity;
    private ArrayList<htNode<K, V>> chains;

    public HashTable() {
        size = 0;
        capacity = 8;
        chains = new ArrayList<htNode<K, V>>(capacity);
        for (int i = 0; i < capacity; i++) {
            chains.add(null);
        }
    }

    public HashTable(int cap) {
        size = 0;
        capacity = cap;
        chains = new ArrayList<htNode<K, V>>(capacity);
    }

    public int getChainIndex(K key) {
        int hashCode = key.hashCode();
        hashCode = hashCode < 0 ? hashCode * -1 : hashCode;

        return hashCode % capacity;
    }

    public V get(K key) {
        int chainIdx = getChainIndex(key);
        htNode<K, V> head = chains.get(chainIdx);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public void add(K key, V value) {
        int chainIdx = getChainIndex(key);

        htNode<K, V> head = chains.get(chainIdx);
        htNode<K, V> nNode = new htNode<K, V>(key, value);

        while (head != null) {
            if (head.getKey().equals(key) && head.getValue().equals(value)) {
                head.value = nNode.value;
                return;
            }
            head = head.next;
        }

        head = chains.get(chainIdx);
        nNode.next = head;
        chains.set(chainIdx, nNode);

        size++;

        if ((size * 1.0f) / capacity >= 0.6f) {
            ArrayList<htNode<K, V>> tmp = chains;

            size = 0;
            capacity *= 2;
            chains = new ArrayList<htNode<K, V>>(capacity);
            for (int i = 0; i < capacity; i++) {
                chains.add(null);
            }

            for (htNode<K, V> chainHead : tmp) {
                while (chainHead != null) {
                    add(chainHead.key, chainHead.value);
                    chainHead = chainHead.next;
                }
            }
        }
    }

    public V remove(K key) {
        int chainIdx = getChainIndex(key);
        htNode<K, V> head = chains.get(chainIdx);

        if (head == null) {
            return null;
        }

        if (head.key.equals(key)) {
            V val = head.value;
            head = head.next;
            chains.set(chainIdx, head);
            size--;
            return val;
        } else {
            htNode<K, V> prev = null;
            while (head != null) {
                if (head.key.equals(key)) {
                    prev.next = head.next;
                    size--;
                    return head.value;
                }

                prev = head;
                head = head.next;
            }

            return null;
        }
    }

    public LinkedList<V> getChainWithKey(K key) {
        int chainIdx = getChainIndex(key);
        htNode<K, V> chainHead = chains.get(chainIdx);
        LinkedList<V> ll = new LinkedList<>();

        while (chainHead != null) {
            ll.addFirst(chainHead.value);
            chainHead = chainHead.next;
        }

        return ll;
    }

    public boolean Empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

}
