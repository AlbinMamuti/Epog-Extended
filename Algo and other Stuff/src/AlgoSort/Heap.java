package AlgoSort;

public class Heap{
	
	int[] heaparray;
	
	public Heap(int [] arr){
		this.heaparray = arr;
	}
	
	
	public void insert(int[] arr) {
		
	}
   public void heapify(int[] arr, int n, int i) {
		
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
	
}