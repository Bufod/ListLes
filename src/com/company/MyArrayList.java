package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T extends Number> implements Iterable<T> {
    private Object[] container;
    private int
            size = 0,
            capacity;

    public MyArrayList(int capacity){
        container = new Object[capacity];
        this.capacity = capacity;
    }

    public MyArrayList(){
        this(10);
    }

    private void resize(Action action){
        Object[] tmp;
        switch (action){
            case EXPAND:
                tmp = new Object[capacity];
                System.arraycopy(container, 0, tmp, 0, size);
                container = tmp;
                break;
            case NARROW:
                tmp = container;
                System.arraycopy(container, 0, tmp, 0, capacity);
        }
    }

    public void add(T obj){
        if (size >= capacity) {
            capacity += capacity*2/3;
            resize(Action.EXPAND);
        }
        container[size] = obj;
        size++;
    }

    public int getSize() {
        return size;
    }

    public void remove(int ind){
        if (size>0) {
            if (ind != size - 1)
                System.arraycopy(container, ind + 1, container, ind, size - ind);

            container[size - 1] = null;
            size--;
            resize(Action.NARROW);
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int ind){
        if (ind >= size || ind < 0)
            throw new ArrayIndexOutOfBoundsException(
                    String.format(
                            "ind: %d at size: %d",
                            ind,
                            size
                    )
            );
        return (T) container[ind];
    }

    @Override
    public String toString() {
        return Arrays.toString(
                Arrays.copyOfRange(
                        container, 0, size
                )
        );
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) container[cursor++];
        }
    }

    enum Action{
        EXPAND,
        NARROW
    }
}
