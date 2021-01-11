package src;

import java.util.LinkedList;
import java.util.PriorityQueue;
class HelloProgrammer{
	public static void main(String[] args) {
		
		int Geld = 50000;
		int Geldprev = 50000;
		
		int  max = Integer.MAX_VALUE;
		System.out.println(isPrime(max));
		
		
		for (int i = 0; i <= 10; i++) {
			
			
			Geld *= 1.07;
			Geld += 50000;
			int Gewinn = Geld - Geldprev; 
			Geldprev = Geld;
			
			System.out.println("Jahr: " + i + " Haben Sie: " + Geld + " CHF");
			System.out.println("Gewinn: "+Gewinn);
			
		}
		
		 PriorityQueue<Pair> heap = new PriorityQueue<>();
		 Pair  i = new Pair(1,0);
		 heap.add(new Pair(1, 10));
		 heap.add(new Pair(2, 1));
		 heap.add(new Pair(3, 15));
		 heap.add(new Pair(4, 13));
		 System.out.println(heap.poll().value);
		 int [][] arr = new int [2][2];
		 System.out.println(heap.contains(i));
		 LinkedList<Integer> list = new LinkedList<>();
		 list.size();
		 System.out.println(Integer.toBinaryString(124));
		 System.out.print(124%2);
		 System.out.print(62%2);
		 System.out.print(31%2);
		 System.out.print(15%2);
		 System.out.print(7%2);
		 System.out.print(3%2);
		 System.out.print(1%2);
		
		 double sum = 0;
		 for(int k = 30; k >= 0; k--) {
			 sum += (1.0/factorialUsingForLoop(k));
		 }
		 System.out.println();
		 System.out.println(sum);
		 System.out.println(Math.E);
		 System.out.println(Math.pow(2, Math.E));
		 double d = Math.pow(2, Math.E);
		 System.out.println(Math.pow(d, 1/Math.E));
		 if((1<2 && 3>5) || (1<2 && 4 < 6)){}
		 recur("abc", 0, "");
		 }
	
	public static int factorialUsingForLoop(int n) {
	    int fact = n;
	    
	    if(n <= 1) {
	    	return 1;
	    }
	    
	    for (int i = n-1; i >= 1; i--) {
	        fact *=  i;
	    }
	    return fact;
	}
	
	 public static void recur(String s, int i, String out)
	    {
	        if (i == s.length()) {
	            System.out.println(out);
	        }
	 
	        // consider each substring S[i, j]
	        for (int j = s.length() - 1; j >= i; j--)
	        {
	            String sub_str = "\"" + s.substring(i, j + 1)
	                            + "\" ";
	 
	            // append the substring to the result and recur with index of
	            // the next character to be processed and result string so far
	            recur(s, j + 1, out + sub_str);
	        }
	    }
	 public static boolean isPrime(int n) {
		 int i = 2;
		 while(i < n) {
			 if(n % i == 0) {
				 return false;
			 }
			 i++;
		 }
		 return true;
			 
	 }
}
class Pair implements Comparable<Pair> {
	  
    public int index;
    public int value;
  
    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        if(this.value < other.value){
          return -1;
        }
        else if(this.value==other.value){
          return 0;
        }
        else{
          return 1;
        }
    }
}