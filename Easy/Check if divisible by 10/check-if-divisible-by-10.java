//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.isDivisibleBy10(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDivisibleBy10(String bin) {
        // code here
        int n = bin.length();
        int power = 1;
        int result = 0;

        // Iterate through the binary string from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If the current bit is '1', add 2^power to the result
            if (bin.charAt(i) == '1') {
                result = (result + power) % 10;
            }
            // Update power for the next bit
            power = (power * 2) % 10;
        }

        // If the result is divisible by 10, return 1; otherwise, return 0
        return (result == 0) ? 1 : 0;
    }
}