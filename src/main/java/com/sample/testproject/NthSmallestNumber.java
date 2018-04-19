package com.sample.testproject;

import java.util.Arrays;
import java.util.Random;

public class NthSmallestNumber {
	
	public static void main(String[] args) {
		
		int n = 20;
		System.out.println("Generating 500 random integers");
        Random aGenerator = new Random();
        int randomArray[] = new int[500];
        for(int i=0; i < 500; i++) {
        	randomArray[i] = aGenerator.nextInt(10000);
        }
        Arrays.sort(randomArray);
        for(int i = 0; i < n; i++){
        	System.out.println(randomArray[i]);
        }
	}
}
