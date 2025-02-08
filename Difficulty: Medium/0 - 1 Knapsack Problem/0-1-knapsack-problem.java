//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int dp[][] = new int[1001][1001];
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int n = wt.length;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = -1;
            }
        }
        return knapSackHelper(capacity,val,wt,wt.length);
    }
    static int knapSackHelper(int capacity, int val[] , int wt[], int n){
        if (capacity == 0 || n == 0) {
        dp[n][capacity] = 0;
        return 0;
    }       
        if(dp[n][capacity]!=-1)
        return dp[n][capacity];
        if(wt[n-1]<=capacity){
            dp[n][capacity] = Math.max(val[n-1]+knapSackHelper(capacity-wt[n-1],val,wt,n-1),knapSackHelper(capacity,val,wt,n-1));
        }
        else{
            dp[n][capacity] = knapSackHelper(capacity,val,wt,n-1); 
        }
        return dp[n][capacity];
    }
}
