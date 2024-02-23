//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
        int temp []= new int[n];
        Arrays.fill(temp,0);
        
        int maxi = price[n-1];
        for(int i=n-2; i>=0 ; i--){
            maxi = Math.max(maxi , price[i]);
            temp[i] = Math.max(temp[i+1], maxi-price[i]);
        }
        int mini = price[0];
        for(int i = 1 ; i<n ; i++){
            mini = Math.min(mini,price[i]);
            temp[i] = Math.max(temp[i-1], price[i]-mini+temp[i]);
        }
        return temp[n-1];
    }
}
        
