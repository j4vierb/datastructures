package graphs;

public class Empresas {
	public int minDistance(int []dist, boolean []shortestPathTreeSet, int V) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for(int v = 0; v < V; v++) {
			if(shortestPathTreeSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}

	public int[] dijkstra(int V, int [][]graph) {
		boolean []shortestPathTreeSet = new boolean[V];
		int []dist = new int[V];

		for(int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			shortestPathTreeSet[i] = false;
		}

		// this is equal to dist[source] = 0
		dist[0] = 0;
		
		int count = 0;
		while(count < V - 1) {
			int u = minDistance(dist, shortestPathTreeSet, V);

			shortestPathTreeSet[u] = true;

			for(int v = 0; v < V; v++) {
				if(!shortestPathTreeSet[v]
						&& graph[u][v] != 0
						&& dist[u] != Integer.MAX_VALUE
						&& dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
			}
		}

		return dist;
	}
	
	public static void main(String []args) {
		Empresas solution = new Empresas();
		int V = 4;
		int [][]graph = {
			{0, 3, 5, 0, 0},
			{3, 0, 2, 7, 0},
			{5, 2, 0, 0, 4},
			{0, 7, 0, 0, 6},
			{0, 0, 4, 6, 0}
		};
		
		int []res = solution.dijkstra(V, graph);
		for(int i = 0; i < res.length; i++)
			System.out.print(res[i]);
		System.out.println("");
	}
}
