package com.space.structure;

import java.util.Arrays;

/**
 * Created by lucifel on 19-5-30.
 */
public class MyArrayStack<E> {

    private int size;
    private Object[] stackData;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayStack() {
        stackData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayStack(int capacity) {
        stackData = new Object[capacity];
    }

    public boolean push(E e){
        if(size + 1 > stackData.length){
            int newCapacity = stackData.length + (stackData.length >> 1 );
            stackData = Arrays.copyOf(stackData,newCapacity);
        }
        stackData[size++] = e;
        return true;
    }

    public E pop(){
        return (E) stackData[--size];
    }

    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack();
        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }

        int count = stack.size;
        for (int i = 0; i < count; i++) {
            System.out.println(stack.pop());
        }
    }
}
