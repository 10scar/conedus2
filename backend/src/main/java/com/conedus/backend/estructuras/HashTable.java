package com.conedus.backend.estructuras;
import java.util.*;
 

public class HashTable<K extends Comparable<K>, V extends Comparable<V>>{
 
    private class htNode<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<htNode<K, V>>{  //Inner hash table node. 
        K key;
        V value;
        htNode<K, V> next; //Same principle as LinkedLists.
 
        public htNode(K key, V value){
            this.key = key;
            this.value = value;
        }
 
        public K getKey(){ return key; }
        public V getValue(){ return value; }
 
        @Override 
        public int compareTo(htNode<K, V> obj){ return key.compareTo(obj.key); } //Compare by key. Reason: Members of same chain.
    }
 
    private int size;
    private int capacity;
    private ArrayList<htNode<K, V>> chains;
 
    /* -HASH TABLE-
     *   K |                         V                              |
     * key0: htNode0_0 -> htNode0_1 -> htNode0_2 -> ... -> htNode0_n
     * key1: htNode1_0 -> htNode1_1 -> htNode1_2 -> ... -> htNode1_n
     * .     .            .            .            ...    .
     * .     .            .            .            ...    .
     * .     .            .            .            ...    .
     * keyn: htNoden_0 -> htNoden_1 -> htNoden_2 -> ... -> htNoden_n
    
     */
 
    public HashTable(){
        size = 0;
        capacity = 8;                //Default initial cap.
        chains = new ArrayList<htNode<K, V>>(capacity);  //Set of chains = hash table. each chain has its own hash associated. 
        for(int i = 0; i < capacity; i++){ chains.add(null); } //Initialize all with null
    }
 
    public HashTable(int cap){
        size = 0;
        capacity = cap;                //Default initial cap.
        chains = new ArrayList<htNode<K, V>>(capacity);  //Set of chains = hash table. each chain has its own hash associated. 
    }
 
    public int getChainIndex(K key){
        int hashCode = key.hashCode();  //Java hash impl. 31 prime
        hashCode = hashCode < 0 ? hashCode * -1 : hashCode; //hashcode() can be < 0.
 
        return hashCode % capacity;
 
    }
 
    public V get(K key){
 
        int chainIdx = getChainIndex(key);
        htNode<K, V> head = chains.get(chainIdx);
 
        while (head != null) {
            if (head.key.equals(key)){ return head.value; }
            head = head.next;
        }
 
        return null;
    }
 
    public void add(K key, V value){
        
        int chainIdx = getChainIndex(key);
 
        htNode<K, V> head = chains.get(chainIdx);
        htNode<K, V> nNode = new htNode<K, V>(key, value);
        
        
        while(head != null){  
            if(head.getKey().equals(key) && head.getValue().equals(value)){ head.value = nNode.value; return; }
            head = head.next; 
        } //All values with same key in single chain
            
        head = chains.get(chainIdx);
        nNode.next = head;
        chains.set(chainIdx, nNode);
            
        size++;
 
 
        //loadFactor check
        if((size * 1.0f) / capacity >= 0.6f){  //Load factor check. Cast of size to float with 1.0
            ArrayList<htNode<K, V>> tmp = chains;  //old array of chains
 
            size = 0;
            capacity *= 2;        //Double up capacity.
            chains = new ArrayList<htNode<K, V>>(capacity);
            for(int i = 0; i < capacity; i++){ chains.add(null); } //Initialize all with null.
 
            for(htNode<K, V> chainHead : tmp){
                while(chainHead != null){
                    add(chainHead.key, chainHead.value); //Class method. Add old values to new table. (see add impl.)
                    chainHead = chainHead.next;
                }
            }       
        }
    }
 
    public V remove(K key){ //Same as LinkedList
        int chainIdx = getChainIndex(key);
        htNode<K, V> head = chains.get(chainIdx);
 
        if(head == null){ return null; }
 
        if(head.key.equals(key)){ //Erase if head.
            V val = head.value;
            head = head.next;
            chains.set(chainIdx, head);
            size--;
            return val;
 
        }else{
            htNode<K, V> prev = null;
            while(head != null){
                if(head.key.equals(key)){
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
 
    public LinkedList getChainWithKey(K key){   //Return chain with associated key.
        int chainIdx = getChainIndex(key);
        htNode<K, V> chainHead= chains.get(chainIdx);
        LinkedList<V> ll = new LinkedList<V>();
 
        while(chainHead != null){ 
            ll.pushFront(chainHead.value);       //Linked List of values given a specific key.
            chainHead = chainHead.next; 
        }
 
        return ll;
    } 
 
 
    //misc.
    public boolean Empty(){ return size == 0; }
    public int getSize(){ return size; }
    public int getCapacity(){ return capacity; }
    
    public static void main(String[] args){
        HashTable<String, Integer> hTable = new HashTable<>();
 
        System.out.println("\nHash Table capacity:");
        System.out.println(hTable.getCapacity()); //Current Max capacity of Hash Table.
 
        hTable.add("TEST", 694);
        hTable.add("TEST", 1);
        hTable.add("TEST", 2);
        hTable.add("TEST", 3);
        hTable.add("TEST", 4);
        hTable.add("TEST", 5);
        hTable.add("TEST01", 420);
        hTable.add("TEST01", 1337);
        hTable.add("TEST01", 420);  //Duplicado, no debe entrar.
 
 
        System.out.println("\nll key TEST:");
        LinkedList<Integer> ll = hTable.getChainWithKey("TEST"); //LinkedList of all values (Chain) associated with key.
        ll.printList();
 
        System.out.println("\nll0 key TEST01:");
        LinkedList<Integer> ll0 = hTable.getChainWithKey("TEST01");
        ll0.printList();
 
        System.out.println("\nll0 Hash Table size:");
        System.out.println(hTable.getSize());
 
        hTable.add("TEST01", 1335);  //9th entry
 
        System.out.println("\nHash Table capacity:");
        System.out.println(hTable.getCapacity()); //New max capacity (double of intiial one)
        
        System.out.println("\nll0 Hash Table size:");
        System.out.println(hTable.getSize());
 
    }
 
}