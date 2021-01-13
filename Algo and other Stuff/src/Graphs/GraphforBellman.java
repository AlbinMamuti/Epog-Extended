package Graphs;

import java.util.LinkedList;

import Graphs.GraphforBellman.Edge;

public class GraphforBellman {
	class Edge {
		int src, dest, weight;

		Edge() {
			src = dest = weight = 0;
		}

		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	};

	int N, M;
	Edge edge[];
	public static int INF = 9999;

	public GraphforBellman(int v, int e, int[][] grid) {
		N = v;
		M = e;
		edge = new Edge[M];
		for (int i = 0; i < M; i++) {
			edge[i] = new Edge();
		}
		readMatrix(grid);

	}

	public void readMatrix(int[][] grid) {
		LinkedList<Edge> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] != INF)
					list.add(new Edge(i, j, grid[i][j]));
			}
		}

		for (int i = 0; i < M; i++) {
			edge[i] = list.removeFirst();
		}

	}
	
	public void BellmanFord(int start) {
		
		int[] dist = new int[N];
		
		for(int i = 0; i < N; i++) {
			dist[i] = INF;
		}
		dist[start] = 0;
		
		for(int i = 1; i < N; i++) {
			for(Edge e: edge) {
				int u = e.src;
				int v = e.dest;
				int w = e.weight;
				
				dist[v] = (dist[u] != INF && dist[u]+w < dist[v]) ? dist[u] + w : dist[v];
				
			}
				
		}
		printerDist(dist);
		
	}
	
	public void printerDist(int[] dist) {
		 System.out.println("Vertex Distance from Source"); 
	        for (int i = 0; i < N; ++i) 
	            System.out.println(i + "\t\t" + dist[i]); 
	}
}
