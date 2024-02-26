//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    List<String> ans;
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        ans = new ArrayList<>();
        solve(s,"" , 0);
        Collections.sort(ans);
        return ans;
    }
    public void solve(String s , String curr , int idx){
        if(idx==s.length() && curr.length()>0){
            ans.add(curr);
            return;
        }
        if(idx<s.length()){
            solve(s,curr,idx+1);
            solve(s,curr+s.charAt(idx),idx+1);
        }
    }
}