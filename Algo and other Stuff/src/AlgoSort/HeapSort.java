package AlgoSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HeapSort {

//	public static void main(String[] args) throws FileNotFoundException {
//		long startTime = System.nanoTime();
//		sort(r());
//		sort(r());
//		sort(r());
//		sort(r());
//		sort(r());
//		long endTime   = System.nanoTime();
//		long totalTime = endTime - startTime;
//		double tT = (double) totalTime / 1000000;
//		System.out.println("Heap Sort");
//		System.out.println(tT + " Tausenstel Sekunden");
//	}
	
	public static void sort(int[] arr) {
		int n = arr.length;
		
		for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
		for(int i = n-1; i >= 0; i--) {
			 int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	 
	            heapify(arr, i, 0);
		}
		
		
	}
	public static void heapify(int[] arr, int n, int i) {
		
		int largest = i;
		int l = 2*i +1;
		int r = 2*i +2;
		
		if (l < n && arr[l] > arr[largest])
            largest = l;
 
        
        if (r < n && arr[r] > arr[largest])
            largest = r;
		
        if(largest!= i) {
        	int temp = arr[i];
        	arr[i] = arr[largest];
        	arr[largest] = temp;
        	heapify(arr, n, largest);
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

