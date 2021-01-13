package Graphs;

public class GrapWithMatrix {
	public static int INF = 9999;
	public int graph[][] = { { INF, 2, 9, 8, INF, INF, INF, INF }, { INF, INF, INF, INF, INF, 2, 8, INF },
			{ INF, INF, INF, INF, 2, INF, INF, INF }, { INF, INF, INF, INF, INF, 7, INF, 1 },
			{ INF, INF, 9, INF, INF, INF, INF, 2 }, { INF, INF, INF, INF, INF, INF, INF, 7 },
			{ INF, INF, INF, INF, INF, 1, INF, INF }, { INF, INF, INF, INF, INF, INF, INF, INF } };
	int n;

	public GrapWithMatrix(int n) {
		this.n = n;
	}

	public void floydWarshall() {

		int dist[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = graph[i][j];
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}
		printSolution(dist);

	}

	public void printSolution(int[][] dist) {
		System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == j)
					System.out.print("0  ");

				else if (dist[i][j] == INF)
					System.out.print("-  ");
				else
					System.out.print(dist[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
