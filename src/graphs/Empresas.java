package graphs;

public class Empresas {
	
	
	public int minDistance(int []dist, Boolean []shortestPathTreeSet, int V) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for(int v = 0; v < V; v++) {
			if(shortestPathTreeSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}

	public int dijkstra(int V, int [][]graph) {
		Boolean []shortestPathTreeSet = new Boolean[V];
		int []dist = new int[V];
		int []parent = new int[V];

		for(int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			shortestPathTreeSet[i] = false;
			parent[i] = -1;
		}

		// this is equal to dist[source] = 0
		dist[0] = 0;
		parent[0] = 0;
		
		int count = 0;
		while(count < V - 1) {
			int u = minDistance(dist, shortestPathTreeSet, V);

			shortestPathTreeSet[u] = true;

			for(int v = 0; v < V; v++) {
				if(!shortestPathTreeSet[v]
						&& graph[u][v] != 0
						&& dist[u] != Integer.MAX_VALUE
						&& dist[u] + graph[u][v] <= dist[v]) {
					dist[v] = dist[u] + graph[u][v];
					parent[v] = u;
				}
			}
			count++;
		}

		int sum = 0;
		
		for(int i = 0; i < V; i++)
			sum += graph[i][parent[i]];
		
		return sum;
	}
	
	public static void main(String []args) {
		Empresas solution = new Empresas();
		int V = 5;
		int [][]graph = {
			{0, 3, 5, 0, 0},
			{3, 0, 2, 7, 0},
			{5, 2, 0, 1, 4},
			{0, 7, 1, 0, 6},
			{0, 0, 4, 6, 0}
		};
 
		int res = solution.dijkstra(V, graph);
		
		System.out.println("Suma minima: " + res);
	}
}
