package Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class GraphDijkstra {
	private int n; // number of vertices
	private int m; // number of edges
	private int[] degrees; // degrees[i]: the degree of vertex i
	private int[][] edges; // edges[i][j]: the endpoint of the j-th edge of vertex i
	private int[][] weights; // weights[i][j]: the weight of the j-th edge of vertex i
	public int[] arr;
	public int[] pred;
	String s;

	final static int INF = 9999;

	GraphDijkstra(int n, int m, int[][] edge_array) {
		this.n = n;
		this.m = m;
		degrees = new int[n];

		s = " ";
		for (int i = 0; i < n; i++) {
			degrees[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			degrees[edge_array[i][0]]++;
			degrees[edge_array[i][1]]++;
		}

		edges = new int[n][];
		weights = new int[n][];

		for (int i = 0; i < n; i++) {
			if (degrees[i] != 0) {
				edges[i] = new int[degrees[i]];
				weights[i] = new int[degrees[i]];
				degrees[i] = 0;
			} else {
				edges[i] = null;
				weights[i] = null;
			}
		}

		for (int i = 0; i < m; i++) {
			edges[edge_array[i][0]][degrees[edge_array[i][0]]] = edge_array[i][1];
			edges[edge_array[i][1]][degrees[edge_array[i][1]]] = edge_array[i][0];
			weights[edge_array[i][0]][degrees[edge_array[i][0]]] = edge_array[i][2];
			weights[edge_array[i][1]][degrees[edge_array[i][1]]] = edge_array[i][2];
			degrees[edge_array[i][0]]++;
			degrees[edge_array[i][1]]++;
		}
	}

	public void Dijkrstra(int start) {

		PriorityQueue<Pair> heaP = new PriorityQueue<>();
		boolean[] visited = new boolean[n]; // wichtig
		arr = new int[n]; // Distances
		pred = new int[n];// fèr pathprinter

		for (int i = 1; i < n; i++) {
			heaP.add(new Pair(-1, i, Integer.MAX_VALUE));
		}
		for (int i = 1; i < n; i++) {
			arr[i] = Integer.MAX_VALUE;
		}

		pred[0] = -1;
		heaP.add(new Pair(-1, 0, 0));
		arr[start] = 0;

		while (!heaP.isEmpty()) {// brucht minim meh Ziit als decrease key --> lohnt sich nöd
			Pair temp = heaP.poll();
			if (visited[temp.currentNode])
				continue;
			visited[temp.currentNode] = true;
			for (int i = 0; i < degrees[temp.currentNode]; i++) {

				int v = edges[temp.currentNode][i];

				if (!visited[v]) {
					if (arr[v] >= arr[temp.currentNode] + weights[temp.currentNode][i]) {
						arr[v] = arr[temp.currentNode] + weights[temp.currentNode][i];
						heaP.add(new Pair(-1, v, arr[v]));
						pred[v] = temp.currentNode;
					}

				}
			}

		}

	}

	public void printerPath() {

		for (int i = 1; i < n; i++) {
			String t = i + " <-- ";
			int k = i;
			while (k != 0 && pred[k] != 0) {
				t += pred[k] + " <-- ";
				k = pred[k];

			}
			t += s;
			s = t;
			s += "0";
			System.out.println(s);
			s = "";
		}

	}

}

class Pair implements Comparable<Pair> {
	int pred;
	int currentNode;
	int val;

	public Pair(int pred, int currentNode, int val) {
		this.pred = pred;
		this.currentNode = currentNode;
		this.val = val;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.val < o.val)
			return -1;
		else if (this.val == o.val)
			return 0;
		else
			return 1;

	}

}
