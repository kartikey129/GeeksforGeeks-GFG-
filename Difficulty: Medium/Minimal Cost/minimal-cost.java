//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, N, K);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minimizeCost(int arr[], int N, int K) {
        // code here
        if(N==0) return 0;
        int dp[] = new int [N];
        dp[0] = 0;
        for(int i=1 ; i<N ; i++){
            int minstep = Integer.MAX_VALUE;
        for(int j=1 ; j<=K ; j++){
            if(i-j>=0){
            int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
            minstep = Math.min(minstep , jump);
        }
        }
        dp[i] = minstep;
    }
    return dp[N-1];
}
}
