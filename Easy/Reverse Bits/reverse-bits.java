//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        // code here
        long result = 0;
        // Iterate over each bit of x
        for (int i = 0; i < 32; i++) {
            // Left shift result by 1 and add the least significant bit of x
            result = (result << 1) | (x & 1);
            // Right shift x by 1 to move to the next bit
            x >>= 1;
        }
        return result;
    }
};