//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
       int maxDiff = 0;
        int[] LMin = new int[n];
        int[] RMax = new int[n];

        // Constructing LMin array
        LMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            LMin[i] = Math.min(a[i], LMin[i - 1]);
        }

        // Constructing RMax array
        RMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            RMax[i] = Math.max(a[i], RMax[i + 1]);
        }

        // Using two pointers to find the maximum difference
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }
}


