//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        for(int i=0 ; i<V; i++){
            if(!visited[i])
            if(checkforCycle(i,V,adj,visited)) return true;
        }
        return false ;
            }
        public boolean checkforCycle(int src , int V , 
                ArrayList<ArrayList<Integer>> adj, boolean visited[]){
                Queue<Pair> que = new LinkedList<>();
                que.add(new Pair(src,-1));
                visited[src] = true;
                while(!que.isEmpty()){
                    int node = que.peek().first;
                    int parent = que.peek().second;
                    que.remove();
                    for(int it : adj.get(node)){
                        if(!visited[it]){
                            que.offer(new Pair(it,node));
                            visited[it]=true;
                        }
                        else if(parent!=it) return true;
                    }
                }
                return false;
    }
}
class Pair{
    int first;
    int second;
    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}