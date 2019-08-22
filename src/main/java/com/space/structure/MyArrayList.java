package com.space.structure;

import java.util.Arrays;

/**
 * Created by lucifel on 19-5-24.
 */
public class MyArrayList<E> {


    private Object[] elementData;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFALT_CAPACITY = 10;
    private int size;

    public MyArrayList(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public MyArrayList(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        }else if(capacity == 0){
            elementData = EMPTY_ELEMENTDATA;
        }
        elementData = new Object[capacity];
    }

    public void add(E e){
        if(size + 1 > elementData.length){
            int newCapacity = elementData.length + (elementData.length >> 1 );
            elementData = Arrays.copyOf(elementData,newCapacity);
        }
        elementData[size++] = e;
    }

    public boolean remove(E e){
        boolean result = false;
        for (int i = 0; i < size ; i++) {
            if(elementData[i].equals(e)){
                remove(i);
                result = true;
            }
        }
        return result;
    }

    public void remove(int index){
        //[0,1,2,3,4,5]
        checkRange(index);
        int moveNum = size - index -1;
        if(moveNum > 0){
            System.arraycopy(elementData,index + 1,elementData,index,moveNum);
        }
        elementData[--size] = null;//把最后一个置为null,并size - 1
    }



    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    public void set(E element,int index){
        checkRange(index);
        elementData[index] = element;
    }


    public int size(){
        return this.size;
    }



    public void checkRange(int index){
        if(index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+this.size);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0;i< size;i++) {
            stringBuilder.append(elementData[i] + ",");
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1,']');
        return stringBuilder.toString();
    }
}
