package com.steveq;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by SteveQ on 2016-10-03.
 */
public class SortingsTester {

    public static void main(String[] args) {

        Sortings bs = new Sortings();
        long startTime;
        long stopTime;

        populateData(bs);
        Collections.shuffle(bs);
        System.out.println(bs);

        startTime = System.nanoTime();
        bs.bubbleSort();
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        System.out.println(bs);

        populateData(bs);
        Collections.shuffle(bs);
        System.out.println(bs);

        startTime = System.nanoTime();
        bs.insertionSort();
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        System.out.println(bs);

        startTime = System.nanoTime();
        bs.selectionSort();
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        System.out.println(bs);

        populateData(bs);
        Collections.shuffle(bs);
        System.out.println(bs);

        startTime = System.nanoTime();
        ArrayList<Integer> result = bs.mergeSort(0, bs.size()-1);
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        System.out.println(result);

        populateData(bs);
        Collections.shuffle(bs);
        System.out.println(bs);

        startTime = System.nanoTime();
        bs.quickSort(0, bs.size()-1);
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        System.out.println(result);

    }

    public static Sortings populateData(Sortings bs){
        bs.clear();
        bs.add(1);
        bs.add(23);
        bs.add(36);
        bs.add(6);
        bs.add(22);
        bs.add(42);
        bs.add(10);
        bs.add(34);
        bs.add(21);
        bs.add(55);
        return bs;
    }

}
