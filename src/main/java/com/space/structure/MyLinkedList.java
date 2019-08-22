package com.space.structure;

/**
 * Created by lucifel on 19-5-24.
 */
public class MyLinkedList<E> {

    private int size;
    private Node<E> first;

    private Node<E> last;


    public void add(E e){
        Node<E> newNode = new Node<>(e,last,null);
        if(first == null){
            first = newNode;
        }else{
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+this.size);
        }
        if(index == size){
            add(e);
        }else{
            Node<E> temp = getNode(index);
            Node<E> prev = temp.prev;
            Node<E> newNode = new Node<E>(e,prev,temp);
            temp.prev = newNode;
            if(prev == null){
                first = newNode;
            }else{
                prev.next = newNode;
            }
        }
        size++;
    }


    public void remove(int index){
        checkRange(index);
        Node<E> temp = getNode(index);
        Node<E> prev = temp.prev;
        Node<E> next = temp.next;
        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            temp.prev = null;
        }

        if (next == null){
            last = prev;
        }else{
            next.prev = prev;
            temp.next = null;
        }
        size--;
        temp.item = null;
    }


    public E get(int index){
        checkRange(index);
        Node<E> result = getNode(index);
        return result == null?null:result.item;
    }

    public Node<E> getNode(int index){
        Node<E> result = null;
        if (index < this.size >> 1){
            Node<E> temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            result = temp;
        }else{
            Node<E> temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
            result = temp;
        }
        return result;
    }


    public void checkRange(int index){
        if(index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+this.size);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<E> temp = first;
        while (temp!= null){
            stringBuilder.append(temp.item + ",");
            temp = temp.next;
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1,']');
        return stringBuilder.toString();
    }

    private static class Node<E>{
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
