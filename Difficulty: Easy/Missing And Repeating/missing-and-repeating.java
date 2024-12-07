//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        long n = arr.length;
        long s2 = 0;
        long s2n = 0;
        long s1 = (n*(n+1))/2;
        long sn = (n*(n+1)*(2*n+1))/6;
        for(int i=0;i<n;i++){
            s2 += arr[i];
            s2n+=(long)arr[i]*(long)arr[i];
        }
        long val1 = s2-s1;
        long val2 = s2n-sn;
        val2 = val2/val1;
        long x = (val1+val2)/2;
        long y = x-val1;
        ans.add((int)x);
        ans.add((int)y);
        return ans;
    }
}