package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {100,200,400,800,1600,3200,6400,12800,25600,51200,102400,204800,409600,819200,1638400};
		for(int i=0;i<15;i++)
		{
			double total=0;
	        for (int j=0;j<100;j++){
	            total+=count(arr[i]);
	        }
	        int avgPairs = (int) (total/100);
	        System.out.println("No. of components : " + arr[i] + ", No. of pairs generated (Avg for 100 experiments):" + avgPairs);
		}

	}

	private static double count(int n) {
		// TODO Auto-generated method stub
		UF_HWQUPC ufc = new UF_HWQUPC(n);
		int c = 0;
        Random random = new Random();
        while(ufc.components()>=2) {
        	int a=random.nextInt(n);
        	int b=random.nextInt(n);
        	ufc.connect(a, b);
        	c++;
	}
        return c;
}
}
