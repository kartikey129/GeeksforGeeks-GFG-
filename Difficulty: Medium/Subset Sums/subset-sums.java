//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSums(arr,n,0,0,ans);
        return ans;
    }
    public void subsetSums(ArrayList<Integer> arr,int n,int ind,int s,ArrayList<Integer> ans ){
        if(ind==n){
            ans.add(s);
            return;
        }
        //include
        s+=arr.get(ind);
        subsetSums(arr,n,ind+1,s,ans);
        //exclude
        s-=arr.get(ind);
        subsetSums(arr,n,ind+1,s,ans);
    }
}