package AlgoSort;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) throws FileNotFoundException {
		
		long startTime = System.nanoTime();
		
		sort(r());
		sort(r());
		sort(r());
		sort(r());
		sort(r());
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		double tT = (double) totalTime / 1000000;
		System.out.println();
		System.out.println(tT + " Tausenstel Sekunden");
	}
	public static void sort(int[] arr) {

		int n = arr.length;

		boolean flag = true;

		for(int i = 1; i < n; i++) {
			int key =arr[i];
			int j = i -1;
			
			while(j >=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}

	}
	public static int[] r() {
		Random rd = new Random(); // creating Random object
	      int[] arr = new int[1000000];
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = rd.nextInt(); // storing random integers in an array
	        
	      }
	      return arr;
	}
}
