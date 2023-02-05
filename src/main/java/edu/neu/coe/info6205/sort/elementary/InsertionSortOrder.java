package edu.neu.coe.info6205.sort.elementary;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.util.Config;

public class InsertionSortOrder {
	
	static InsertionSort inserstionSort = new InsertionSort();
	
    
    private static Integer[] generateRandom(int n) {
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n * 10);
        }
        return arr;
    }

    private static Integer[] generateOrdered(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static Integer[] generatePartiallyOrdered(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n / 2; i++) {
            arr[i] = i * 2;
        }
        for (int i = n / 2; i < n; i++) {
            arr[i] = (n - i) * 2;
        }
        return arr;
    }

    private static Integer[] generateReverseOrdered(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }



    private static void measureTime(Integer[] arr, int numExperiments) {
    	long totalTime=0;
    	for (int i = 0; i < numExperiments; i++) {
            Integer[] arrCopy = arr.clone();
            long startTime = System.nanoTime();
            inserstionSort.sort(arrCopy,0,arrCopy.length);
            long endTime = System.nanoTime();
            totalTime += endTime - startTime;
        }
        long meanTime = totalTime / numExperiments;
        System.out.println("Mean elapsed time: " + meanTime/Math.pow(10, 6) + "ms");
    	
    }
    
    public static void main(String[] args) {
        int[] n = {500, 1000, 2000, 4000, 8000, 16000};
        int numExperiments = 50;

        for (int i = 0; i < n.length; i++) {
            Integer[] random = generateRandom(n[i]);
            Integer[] ordered = generateOrdered(n[i]);
            Integer[] partiallyOrdered = generatePartiallyOrdered(n[i]);
            Integer[] reverseOrdered = generateReverseOrdered(n[i]);

            System.out.println("No.of elements in array  = " + n[i]);

            System.out.print("Random array: ");
            measureTime(random, numExperiments);

            System.out.print("Ordered array: ");
            measureTime(ordered, numExperiments);

            System.out.print("Partially ordered array: ");
            measureTime(partiallyOrdered, numExperiments);

            System.out.print("Reverse ordered array: ");
            measureTime(reverseOrdered, numExperiments);

            System.out.println();
        }
    }

}
