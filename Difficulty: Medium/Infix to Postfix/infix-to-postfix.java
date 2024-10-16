//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        String ans  = "";
        int i=0 ;
        int n = exp.length();
        Stack<Character> st = new Stack<>();
        while(i<n){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ans+=ch;
            }
            else if(ch=='(' ) st.push(ch);
            else if(ch==')' ){
                while(!st.isEmpty() && st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(ch)<=priority(st.peek())){
                    ans+=st.pop();
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
    public static int priority(char ch){
        if(ch=='^') return 3;
        if(ch=='*' || ch=='/') return 2;
        if(ch=='+' || ch=='-') return 1;
        else return -1;
    }
}