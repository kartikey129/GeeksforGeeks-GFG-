//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        return solve(arr, sum, 0, 0, n);
    }

    static Boolean solve(int arr[], int target, int sum, int ind, int n) {
        // Base case: If we have processed all elements
        if (ind == n) {
            return sum == target;
        }

        // Include current element and check
        if (sum + arr[ind] <= target && solve(arr, target, sum + arr[ind], ind + 1, n)) {
            return true;
        }

        // Exclude current element and check
        if (solve(arr, target, sum, ind + 1, n)) {
            return true;
        }

        return false; // No valid subset found
    }
}