import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Bfs{

    public static ArrayList<Integer> bfsOfGraph(int N, ArrayList<ArrayList<Integer>> adj){
        
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[N];

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            Integer cur = q.poll();
            bfs.add(cur);
            for(Integer it: adj.get(cur)){
                if(!visited[it]){
                    q.add(it);
                    visited[it] = true;
                }
            }
        }
        return bfs;
    }

    static void printAns(ArrayList < Integer > ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList <ArrayList<Integer>> adj = new ArrayList <> ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);


        ArrayList<Integer> ans = bfsOfGraph(5, adj);
        printAns(ans);
    }
}