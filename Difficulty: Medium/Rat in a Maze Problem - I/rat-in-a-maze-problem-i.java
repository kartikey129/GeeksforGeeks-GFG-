//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.size();
        if(n==0 || mat.get(0).get(0)==0)
        return ans;
        solve(0,0,"",ans,mat,n);
        Collections.sort(ans);
        return ans;
    }
    public void solve(int i, int j,String str, ArrayList<String> ans, ArrayList<ArrayList<Integer>> mat, int n){
      if (i < 0 || j < 0 || i >= n || j >= n || mat.get(i).get(j) == 0) {
            return;
        }
         if (i == n-1 && j == n-1) {
            ans.add(str);
            return;
        }
        mat.get(i).set(j, 0);
                    //Up
                    solve(i+1,j,str+'D',ans,mat,n);
                    //down
                    solve(i-1,j,str+'U',ans,mat,n);
                    //left
                    solve(i,j+1,str+'R',ans,mat,n);
                    //right
                    solve(i,j-1,str+'L',ans,mat,n);
                mat.get(i).set(j, 1);
    }
            }