package com.pickyourtrail.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingPairs {
    private int numberOfElements;
    private int elementsArray[];
    private int differenceValue;

    public static void main(String args[]){
        CountingPairs countingPairs = new CountingPairs();
        countingPairs.getUserInputs();
        int pairs = countingPairs.computeCountingPairs();
        System.out.println(pairs);
    }

    /**
     * computeCountingPairs computes the pair count with given difference
     */
    private int computeCountingPairs() {
        int arraySize = this.numberOfElements;
        Map<Integer,Integer> visitedPair = new HashMap<>();
        int pairCount = 0;
        for(int rowIndex =0; rowIndex<arraySize; rowIndex++){
            for (int colIndex=0;colIndex<rowIndex;colIndex++){
                int rowValue = this.elementsArray[rowIndex];
                int colValue = this.elementsArray[colIndex];
                if(Math.abs(rowValue - colValue) == this.differenceValue){
                    if(!(visitedPair.containsKey(rowValue) && visitedPair.get(rowValue).equals(colValue))
                    && !(visitedPair.containsKey(colValue) && visitedPair.get(colValue).equals(rowValue))){
                        visitedPair.put(rowValue,colValue);
                        pairCount++;
                    }
                    
                }
            }
        }
        return pairCount;
    }

    /**
     * getUserInputs is to get the input from user
     */
    private void getUserInputs() {
        int numberOfElements;
        int elementsArray[];
        Scanner inputScanner = new Scanner(System.in);
        numberOfElements = inputScanner.nextInt();
        elementsArray = new int[numberOfElements];
        for(int index=0;index<numberOfElements;index++){
            elementsArray[index] = inputScanner.nextInt();
        }
        this.numberOfElements = numberOfElements;
        this.elementsArray = elementsArray;
        this.differenceValue = inputScanner.nextInt();

    }
}
