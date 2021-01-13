package Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
	private int n; // number of vertices
	private int m; // number of edges
	private int[] degrees; // degrees[i]: the degree of vertex i
	private int[][] edges; // edges[i][j]: the endpoint of the j-th edge of vertex i
	private int[][] weights; // weights[i][j]: the weight of the j-th edge of vertex i
	public Set<Integer> set1 = new HashSet<>();
	public int[] arr;
	public int[] pred;
	String s;

	final static int INF = 9999;

	Graph(int n, int m, int[][] edge_array) {
		this.n = n;
		this.m = m;
		degrees = new int[n];
		arr = new int[n];
		pred = new int[n];
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
		for (int i = 1; i < n; i++) {
			heaP.add(new Pair(-1, i, Integer.MAX_VALUE));
			set1.add(i);
		}
		pred[0] = 0;
		heaP.add(new Pair(-1, 0, 0));
		set1.add(0);
		arr[start] = 0;
		for (int i = 1; i < n; i++) {
			arr[i] = Integer.MAX_VALUE;
		}

		Set<Integer> compare = new HashSet<>();
		while (!compare.equals(set1)) {
			Pair temp = heaP.poll();
			compare.add(temp.currentNode);
			for (int i = 0; i < degrees[temp.currentNode]; i++) {
				int v = edges[temp.currentNode][i];
				if (!compare.contains(v)) {
					arr[v] = Math.min(arr[v], arr[temp.currentNode] + weights[temp.currentNode][i]);
					heaP.add(new Pair(-1, v, arr[v]));
					if (arr[v] >= arr[temp.currentNode] + weights[temp.currentNode][i])
						pred[v] = temp.currentNode;
				}
			}

		}

	}

	public void decreaseKey(PriorityQueue<Pair> heap, int node, int weight) {

		Iterator<Pair> iterator = heap.iterator();
		while (iterator.hasNext()) {
			Pair tempPair = iterator.next();
			if (tempPair.currentNode == node)
				tempPair.val = weight;
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

	public void rec(int k) {
		if (k == 0) {
			return;
		} else {
			s += " <-- " + pred[k];
			rec(pred[k]);
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
