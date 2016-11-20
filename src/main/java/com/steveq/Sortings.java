package com.steveq;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

/**
 * Created by SteveQ on 2016-10-03.
 */
public class Sortings extends ArrayList<Integer> {

    public Sortings(){
        super();
    }

    public void bubbleSort(){
        for(int i=0; i < this.size()-1; i++){
            for(int j=0; j < this.size() - 1; j++){
                if(parseInt(this.get(j).toString()) > parseInt(this.get(j+1).toString())) {
                    Collections.swap(this, j, j + 1);
                }
            }
        }
    }

    public void selectionSort(){
        int lowest;
        for(int i = 0; i < this.size(); i++){
            lowest = i;
            for(int j = i+1; j < this.size(); j++){
                if(this.get(j) <this.get(lowest)){
                    lowest = j;
                }
            }
            Collections.swap(this, lowest, i);
        }
    }

    public void insertionSort(){
        Integer key;
        for(int i=1; i < this.size(); i++){
            key = this.get(i);
            int j = i-1;
            while(j>-1){
                if(this.get(j) > key){
                    this.set(j+1, this.get(j));
                } else break;
                j--;
            }
            this.set(j + 1, key);
        }
    }

    public ArrayList<Integer> mergeSort(int firstIndex, int lastIndex){

        ArrayList<Integer> subArrayList = new ArrayList<Integer>(this.subList(firstIndex, lastIndex+1));
        if(firstIndex < lastIndex){
            int midIndex = (int)Math.floor((firstIndex+lastIndex)/2);
            subArrayList = mergeSort(firstIndex, midIndex);
            subArrayList.addAll(mergeSort(midIndex+1, lastIndex));
            subArrayList = merge(subArrayList, firstIndex, midIndex, lastIndex);
        } else {
            return subArrayList;
        }
        return subArrayList;
    }

    public ArrayList<Integer> merge(ArrayList aList, int firstIndex, int middleIndex, int lastIndex){

        ArrayList<Integer> leftStack = new ArrayList<Integer>(aList.subList(firstIndex - firstIndex, middleIndex+1- firstIndex));
        ArrayList<Integer> rightStack = new ArrayList<Integer>(aList.subList(middleIndex+1- firstIndex, lastIndex+1- firstIndex));
        ArrayList<Integer> subList = new ArrayList<Integer>();

        leftStack.add(leftStack.size(), (int)Double.POSITIVE_INFINITY);
        rightStack.add(rightStack.size(), (int)Double.POSITIVE_INFINITY);

        while(leftStack.size()!=1 || rightStack.size()!=1){
            if((Integer)leftStack.get(0) <= (Integer)rightStack.get(0)){
                subList.add(leftStack.get(0));
                leftStack.remove(0);
            } else{
                subList.add(rightStack.get(0));
                rightStack.remove(0);
            }
        }
        return subList;
    }

    public boolean quickSort(int firstIndex, int lastIndex){

        int pivotPosition;

        if(firstIndex >= lastIndex) return true;
        else{
            pivotPosition = doSplit(firstIndex, lastIndex);
            quickSort(firstIndex, pivotPosition-1);
            quickSort(pivotPosition+1, lastIndex);
        }
        return true;
    }

    private int doSplit(int firstIndex, int lastIndex) {

        int p = 0;
        int q = 0;
        int r = lastIndex;

        for(int u=0; u<r; u++) {
            if (this.get(u) <= this.get(r)) {
                Collections.swap(this, u, q);
                q++;
            }
        }
        Collections.swap(this, q, r);

        return q;
    }

}
