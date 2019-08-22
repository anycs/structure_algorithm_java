package com.space.structure;

/**
 * Created by lucifel on 19-5-27.
 */
public class MyHashMap<K,V> {

    private Node<K,V>[] table;
    private static final int DEFAULT_ARRAY_SIZE = 16;
    private int size;

    public MyHashMap() {
        table = (Node<K,V>[])new Node[DEFAULT_ARRAY_SIZE];
    }

    public void put(K key,V value){
        int node_hash = myHash(key,table.length);
        Node<K,V> first = table[node_hash];
        Node<K,V> newNode = new Node<K,V>(node_hash,key,value,null);
        if(first == null){
            table[node_hash] = newNode;
            size++;
        }else{
            Node<K,V> temp = first;
            for (int i = 0;;i++) {
                if(key.equals(temp.key)){
                    temp.value = value;
                    break;
                }
                if(temp.next == null){
                    temp.next = newNode;
                    size++;
                    break;
                }
                temp = temp.next;
            }
        }

    }

    public V get(K key){
        int hash = myHash(key,table.length);
        Node<K,V> temp = table[hash];
        if(temp == null){
            return null;
        }else{
            while (temp != null){
                if(key == null && temp.key == null){
                    return temp.value;
                }
                if(key.equals(temp.key)){
                    return temp.value;
                }
                temp = temp.next;
            }
            return null;
        }
    }




    public int size(){
        return this.size;
    }

    private int myHash(K key,int length){
        return key==null?0:(key.hashCode()&(length - 1));
    }


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("{");
        for (int i = 0; i < table.length; i++) {
            Node<K,V> temp = table[i];
            while (temp != null){
                stringBuffer.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        stringBuffer.setCharAt(stringBuffer.lastIndexOf(","),'}');
        return stringBuffer.toString();
    }

    static class Node<K,V>{
        int hash;
        K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
