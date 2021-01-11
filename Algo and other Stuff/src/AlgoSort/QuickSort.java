package AlgoSort;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;
public class QuickSort {

	
	public static void main (String[] arg) throws FileNotFoundException {
		
		
		int[] arr1 = r();
		int[] arr2 = r();
		int[] arr3 = r();
		int[] arr4 = r();
		int[] arr5 = r();
		int[] arr6 = r();
		int[] arr7 = r();
		int[] arr8 = r();
		int[] arr9 = r();
		int[] arr10 = r();
		long startTime = System.nanoTime();
		QuickSort(arr1, 0, 10000000-1);
		QuickSort(arr2, 0, 10000000-1);
		QuickSort(arr3, 0, 10000000-1);
		QuickSort(arr4, 0, 10000000-1);
		QuickSort(arr5, 0, 10000000-1);
		QuickSort(arr6, 0, 10000000-1);
		QuickSort(arr7, 0, 10000000-1);
		QuickSort(arr8, 0, 10000000-1);
		QuickSort(arr9, 0, 10000000-1);
		QuickSort(arr10, 0, 10000000-1);
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		double tT = (double) totalTime / 1000000000;
		
		System.out.println("QuickSort");
		System.out.println(tT + "  Sekunden");
		System.out.println(isSorted(arr1) && isSorted(arr2) && isSorted(arr3) && isSorted(arr4) && isSorted(arr5));
	}
	
	public static int[] QuickSort(int[] arr, int low, int high) {
		
		if(low<high) {
			int piv = partition(arr, low, high);
			
			QuickSort(arr, low, piv-1);
			QuickSort(arr, 1+piv, high);
		}
		
		
		
		return arr;
	}
	
	public static int partition(int[]arr, int low, int high) {
		
		int pivot = arr[high]; //select last element as Pivot;
		int i = low -1 ; // select i as -1 for tracking
		
		for(int j = low; j < high; j++) {
			if(arr[j] < pivot) {
				i++;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
		
	}
	
	public static int[] r() {
		Random rd = new Random(); // creating Random object
	      int[] arr = new int[10000000];
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = rd.nextInt(); // storing random integers in an array
	        
	      }
	      return arr;
	}
	static boolean isSorted(int[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
	        if (array[i] > array[i + 1])
	            return false;
	    }
	    return true;
	}
}
