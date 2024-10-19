//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        int m = a.length;
        int n = b.length;
        while(p1<m && p2<n){
            if(a[p1]==b[p2]){
                if(ans.isEmpty() || ans.get(ans.size() - 1) != a[p1])
                ans.add(a[p1]);
                p1++;
                p2++;
            }
            else if(a[p1]<b[p2]){
                if(ans.isEmpty() || ans.get(ans.size() - 1) != a[p1])
                ans.add(a[p1]);
                p1++;
            }
            else{
                if(ans.isEmpty() || ans.get(ans.size() - 1) != b[p2])
                ans.add(b[p2]);
                p2++;
            }
        }
        while(p1<m){
            if(ans.isEmpty() || ans.get(ans.size() - 1) != a[p1])
                ans.add(a[p1]);
                p1++;
        }
        while(p2<n){
            if(ans.isEmpty() || ans.get(ans.size() - 1) != b[p2])
                ans.add(b[p2]);
                p2++;
        }
        return ans;  
    }
}
