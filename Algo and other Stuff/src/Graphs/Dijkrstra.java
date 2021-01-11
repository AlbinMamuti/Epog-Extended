package Graphs;
import AlgoSort.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dijkrstra {
	
	public static void main(String[] arg) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("EBNF2.txt"));
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] edge_array=new int[m][3];
		for(int i=0;i<m;i++){
	          edge_array[i][0]=scanner.nextInt();  // one endpoint
	          edge_array[i][1]=scanner.nextInt();  // the other endpoint
	          edge_array[i][2]=scanner.nextInt();  // weight
	        }
		
		Graph G= new Graph(n, m, edge_array);
		HeapSort s = new HeapSort();
		int[][] arr = new int[4][5];
		System.out.println(arr[0].length);
		
	}
	
}

class Graph{
	private int n;              // number of vertices
	  private int m;              // number of edges
	  private int[] degrees;      // degrees[i]: the degree of vertex i
	  private int[][] edges;      // edges[i][j]: the endpoint of the j-th edge of vertex i
	  private int[][] weights;    // weights[i][j]: the weight of the j-th edge of vertex i
	  
	  Graph(int n, int m, int[][] edge_array){
		    this.n=n;
		    this.m=m;
		    degrees=new int[n];
		    
		    for(int i=0;i<n;i++){
		      degrees[i]=0;
		    }
		   
		    for(int i=0;i<m;i++){
		      degrees[edge_array[i][0]]++;
		      degrees[edge_array[i][1]]++;
		    }
		    
		    edges=new int[n][];
		    weights=new int[n][];
		      
		    for(int i=0;i<n;i++){
		      if(degrees[i]!=0){
		        edges[i]=new int[degrees[i]];
		        weights[i]=new int[degrees[i]];
		        degrees[i]=0;
		      }
		      else{
		        edges[i]=null;
		        weights[i]=null;
		      }
		    }
		    
		    for(int i=0;i<m;i++){
		      edges[edge_array[i][0]][degrees[edge_array[i][0]]]=edge_array[i][1];
		      edges[edge_array[i][1]][degrees[edge_array[i][1]]]=edge_array[i][0];
		      weights[edge_array[i][0]][degrees[edge_array[i][0]]]=edge_array[i][2];
		      weights[edge_array[i][1]][degrees[edge_array[i][1]]]=edge_array[i][2];
		      degrees[edge_array[i][0]]++;
		      degrees[edge_array[i][1]]++;
		    } 
		  }
	  
	  
}