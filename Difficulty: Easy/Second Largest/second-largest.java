//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int largest = 0;
        int secondLargest = -1;
        for(int i=0; i<arr.length; i++){
            if(largest<arr[i]){
                secondLargest = largest;
                largest = arr[i];
                
            }
            if(secondLargest<arr[i] && arr[i]<largest){
                secondLargest = arr[i];
            }
        }
        return (secondLargest==0) ? -1 : secondLargest;
    }
}