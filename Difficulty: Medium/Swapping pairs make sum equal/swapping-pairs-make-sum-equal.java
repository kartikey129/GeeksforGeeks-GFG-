//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        Arrays.sort(a);
        Arrays.sort(b);
       long target = gettarget(a,n,b,m);
       if(target==0)
       return 1;
       int i = 0 ; 
       int j = 0 ;
       while(i<n && j<m){
           long diff = Math.abs(a[i]-b[j]);
           if(diff == target ) return 1;
           else if(diff<target)
           i++;
           else{
               j++;
           }
       }
       return -1;
    }
    
       long getSum(long a[] , long x ){
           int sum = 0 ; 
           for(int i=0 ; i<x ; i++){
               sum+=a[i];
           }
           return sum;
       }
       long gettarget(long a[] , int n , long b[] , int m ){
           long sum1 = getSum(a,n);
           long sum2 = getSum(b,m);
           
           if(Math.abs(sum1 - sum2)%2!=0) return -1;
           return Math.abs(sum1-sum2)/2;
        }
    }


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends