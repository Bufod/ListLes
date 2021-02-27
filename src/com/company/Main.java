package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        System.out.println(myArrayList);

        myArrayList.remove(2);
        System.out.println(myArrayList);

        myArrayList.add(2);
        System.out.println(myArrayList);

        System.out.println(myArrayList.get(0));

        for (Integer el : myArrayList){
            System.out.print(el + " ");
        }
    }
}
