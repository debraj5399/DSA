import java.util.ArrayList;
import java.util.Arrays;

class Dfs{

    public static void dfsTraversal(int node, ArrayList<Integer> dfs ,ArrayList<ArrayList<Integer>> adj,  boolean[] visited){
        dfs.add(node);
        visited[node] = true;
        for(Integer it: adj.get(node)){
            if(!visited[it]){
                dfsTraversal(it, dfs, adj, visited);
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(int N, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean [] visited = new boolean[N+1];
        Arrays.fill(visited, false);

        for(int i = 1; i <=N; i++){
            if(!visited[i]){
                dfsTraversal(i, dfs, adj, visited);
            }
        }   
        return dfs;
    }

    public static void printAns(ArrayList < Integer > ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList <> ());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(1).add(5);
        adj.get(2).add(4);
        adj.get(2).add(1);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(4).add(2);
        adj.get(5).add(1);

        ArrayList <Integer> ans = dfsOfGraph(5, adj);
        printAns(ans);
    }
}