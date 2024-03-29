//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            boolean ans = obj.isEularCircuitExist(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     int[] vis;
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        vis = new int[v+1];
        //checking conencted or not
        dfs(0, vis, adj);
        
        for (int i = 0; i < v; i++) 
        {
            if (vis[i]==0 && adj.get(i).size()>0)
                return false; // not connected
        }
            
        //2
        int cnt = 0;
        for (int i = 0; i < v; i++) {
            if ((adj.get(i).size() % 2) == 1)
                cnt++;
        }
       //violates the condition for exaclty once 
        if (cnt > 2)
             return false; 

    //making, sure exaclty once and diff start and end
       else if(cnt==2) return false; //EP
        // if(cnt==0)
       else  return true; //EC - forming one whole cycle
       
    }
    
    void dfs(int u, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[u] = 1;
        for (int v : adj.get(u)) {
            if (vis[v]==0)
                dfs(v, vis, adj);
    }
}
}