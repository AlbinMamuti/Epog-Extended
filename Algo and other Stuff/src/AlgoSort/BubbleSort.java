package AlgoSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		sort(r());
//		sort(r());
//		sort(r());
//		sort(r());
//		sort(r());
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		double tT = (double) totalTime / 1000000;
		System.out.println();
		System.out.println(tT + " Tausenstel Sekunden");
	}

	public static void sort(int[] arr) {

		int n = arr.length;

		boolean flag = true;

		for(int i = 0; i < n; i++) {
			for(int j  = 0; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int[] r() {
		Random rd = new Random(); 
	      int[] arr = new int[1000000];
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = rd.nextInt(); 
	        
	      }
	      return arr;
	}
	
}
