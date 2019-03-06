package com.pickyourtrail.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumUniqueSum {
    public static void main(String args[]){
        MinimumUniqueSum minimumUniqueSum = new MinimumUniqueSum();
        int elementsArray[] = minimumUniqueSum.getUserInputs();
        int minimumSum = minimumUniqueSum.getMinimumUniqueSum(elementsArray);
        System.out.println(minimumSum);
    }

    /**
     * getUserInputs method is to get the inputs from the user
     *
     * @return integer array
     */
    private int[] getUserInputs() {
        int numberOfElements;
        int elementsArray[];
        Scanner inputScanner = new Scanner(System.in);
        numberOfElements = inputScanner.nextInt();
        elementsArray = new int[numberOfElements];
        for(int index=0;index<numberOfElements;index++){
            elementsArray[index] = inputScanner.nextInt();
        }
        return elementsArray;
    }

    /**
     * getMinimumUniqueSum computes the minimum unique sum by modifying the duplicates
     * @param elementsArray
     * @return
     */
    private int getMinimumUniqueSum(int[] elementsArray) {
        List<Integer> elementsList = new ArrayList<>();
        int minimalSum = 0;
        for (int i=0;i<elementsArray.length ; i++){
            while(elementsList.contains(elementsArray[i])){
                elementsArray[i]+=1;
            }
            elementsList.add(elementsArray[i]);
            minimalSum+=elementsArray[i];
        }
        return minimalSum;
    }
}
