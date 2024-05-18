//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findPeakElement(List<Integer> a) {
        // Code here
        int start = 0;
        int end = a.size()-1;
        int mid = start + (end - start)/2;
        while(start<=end){
            
            boolean isLeftSmaller = (mid == 0 || a.get(mid) > a.get(mid - 1));
            boolean isRightSmaller = (mid == a.size() - 1 || a.get(mid) > a.get(mid + 1));
            
            if(isLeftSmaller && isRightSmaller) return a.get(mid);
            
            if(mid>0 && a.get(mid)<a.get(mid-1)) end = mid-1;
            else start=mid+1;
            mid = start + (end - start)/2;
        }
        return -1;
    }
}