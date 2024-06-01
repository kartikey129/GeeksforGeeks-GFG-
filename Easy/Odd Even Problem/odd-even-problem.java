//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        int[] freq = new int[26];
        
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        int x = 0, y = 0;
        
        for (int i = 0; i < 26; i++) {
            int frequency = freq[i];
            int position = i + 1;
            
            if (position % 2 == 0) {
                if (frequency % 2 == 0 && frequency > 0) {
                    x++;
                }
            } else {
                if (frequency % 2 == 1) {
                    y++;
                }
            }
        }
        
        int sum = x + y;
        
        if (sum % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }
}
