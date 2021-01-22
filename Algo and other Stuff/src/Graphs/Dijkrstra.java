package Graphs;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Dijkrstra {

	public static int INF = 9999;
	
	public static void main(String[] arg) throws FileNotFoundException {
		DijkShort();
		System.out.println();
		FloydShort();
		System.out.println();
		Bellman();
		System.out.println();
	}

	public static void DijkShort() throws FileNotFoundException { // running Dijkstra on input File EBNF3.txt
		
		Scanner scanner = new Scanner(new File("EBNF3.txt"));

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] edge_array = new int[m][3];
		for (int i = 0; i < m; i++) {
			edge_array[i][0] = scanner.nextInt(); // one endpoint
			edge_array[i][1] = scanner.nextInt(); // the other endpoint
			edge_array[i][2] = scanner.nextInt(); // weight
		}

		GraphDijkstra G = new GraphDijkstra(n, m, edge_array);

		G.Dijkrstra(0);
		for(int i = 0; i < n; i++)
			System.out.print(i +" ");
		System.out.println();
		for (int i = 0; i < G.arr.length; i++) 
			System.out.print(G.arr[i] + " ");

		
		System.out.println();
		for (int i = 0; i < G.arr.length; i++) 
			System.out.print(G.pred[i] + " ");

		
		System.out.println();
		G.printerPath();
	}

	public static void FloydShort() throws FileNotFoundException { // running FloydWarshall on input File EBNF5.txt
		Scanner scanner3 = new Scanner(new File("EBNF5.txt"));
		int n = scanner3.nextInt();
		int m = scanner3.nextInt();
		int[][] grid = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.MAX_VALUE;
				if (i == j)
					grid[i][j] = Integer.MIN_VALUE;
			}
		}
		while (scanner3.hasNext()) {
			int u, v, w;
			u = scanner3.nextInt();
			v = scanner3.nextInt();
			w = scanner3.nextInt();
			grid[u][v] = w;
			// grid[v][u] = w;
		}
		GraphFloydWarshall graph = new GraphFloydWarshall(n);
		// graph.graph = grid;
		graph.floydWarshall();
	}
	public static void Bellman() { // running Bellman ford with an input arr
		
		int[][] arr = { { INF, 2, 9, 8, INF, INF, INF, INF }, { INF, INF, INF, INF, INF, 2, 8, INF },
				{ INF, INF, INF, INF, 2, INF, INF, INF }, { INF, INF, INF, INF, INF, 7, INF, 1 },
				{ INF, INF, 9, INF, INF, INF, INF, 2 }, { INF, INF, INF, INF, INF, INF, INF, 7 },
				{ INF, INF, INF, INF, INF, 1, INF, INF }, { INF, INF, INF, INF, INF, INF, INF, INF } };
		
		GraphforBellman G = new GraphforBellman(8, 12, arr);
		
		G.BellmanFord(0);
		
	}

}











