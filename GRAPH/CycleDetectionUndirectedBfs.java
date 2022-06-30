import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class CycleDetectionUndirectedBfs {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(i, new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);

        Solution obj = new Solution();
        boolean ans = obj.isCycle(V, adj);
        if (ans)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

class Node {
    int first;
    int second;

    Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public boolean checkForCycle(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node, -1));
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for (Integer it : adj.get(cur)) {
                if (visited[it] == false) {
                    q.add(new Node(it, cur));
                    visited[it] = true;
                } else if (it != par) {
                    return true;
                }
            }
            return false;

        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (checkForCycle(i, visited, adj) == true)
                return true;
        }

        return false;
    }
}