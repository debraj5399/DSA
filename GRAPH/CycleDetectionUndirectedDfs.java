import java.util.ArrayList;

class CycleDetectionUndirectedDfs {
    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // edge 0---1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // adge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // adge 3--4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // adge 1--4
        adj.get(1).add(4);
        adj.get(4).add(1);

        Solution obj = new Solution();
        boolean ans = obj.isCycle(V, adj);
        if (ans == true) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");

        }
    }
}

class Solution {

    public boolean checkForCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        visited[node] = true;

        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                if (checkForCycle(it, node, adj, visited))
                    return true;
            } else if (it == node) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int N, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (checkForCycle(i, -1, adj, visited))
                    return true;
            }
        }

        return false;
    }
}
