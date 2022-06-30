import java.util.ArrayList;
import java.util.Arrays;

class CycleDetectionDirectedDfs {

    public static boolean dfsCheckCyclic(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] dfsVisited) {

        visited[node] = 1;
        dfsVisited[node] = 1;

        for (Integer it : adj.get(node)) {
            if (visited[it] == 0) {
                if (dfsCheckCyclic(it, adj, visited, dfsVisited))
                    return true;
            } else if (dfsVisited[it] == 1) {
                return true;
            }

        }
        dfsVisited[node] = 0;
        return false;
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] visited = new int[V];
        int[] dfsVisited = new int[V];
        Arrays.fill(visited, 0);
        Arrays.fill(dfsVisited, 0);

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfsCheckCyclic(i, adj, visited, dfsVisited))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);

        // Vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        neighbors.add(1);
        graph.add(neighbors);

        // Vertex - 1
        neighbors = new ArrayList<Integer>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        // Vertex - 2
        neighbors = new ArrayList<Integer>();
        neighbors.add(3);
        graph.add(neighbors);

        // Vertex - 3
        neighbors = new ArrayList<Integer>();
        neighbors.add(4);
        graph.add(neighbors);

        // Vertex - 4
        neighbors = new ArrayList<Integer>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        // Vertex - 5
        neighbors = new ArrayList<Integer>();
        graph.add(neighbors);

        if (isCyclic(V, graph))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycles detected");
    }
}
