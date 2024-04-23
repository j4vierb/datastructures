package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Can be used to Shortest Path finding in an unweighted graph, cycle detection.
 * 
 * O(V + E)
 */
public class BFS {
	/**
	 * Basic search in a graph using Breath-First Search algorithm
	 * 
	 * @param graph
	 * @param src
	 */
	public void normal_bfs(int [][]graph, int src) {
		int V = graph.length;
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean []visited = new boolean[V];
		Arrays.fill(visited, false);
		
		int []parents = new int[V];
		Arrays.fill(parents, -1);
		
		q.add(src);
		visited[src] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			System.out.println("[+] new node find: " + node);
			
			for(int i = 0; i < V; i++) {
				if(graph[node][i] != 0 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					parents[i] = node;
				}
			}
		}
		
		System.out.println("Printing parents: ");
		for(int i = 0; i < V; i++) {
			System.out.format("Parent of %d is %d\n", i, parents[i]);
		}
	}
	
	public boolean traverseThePathNSteps() {
		
		return true;
	}

	public static void main(String []args) {
		int [][]graph = {
			{0, 1, 1, 0},
			{1, 0, 2, 0},
			{1, 2, 0, 3},
			{0, 0, 3, 0}
		};
		BFS bfs = new BFS();
		bfs.normal_bfs(graph, 0);
	}
}
