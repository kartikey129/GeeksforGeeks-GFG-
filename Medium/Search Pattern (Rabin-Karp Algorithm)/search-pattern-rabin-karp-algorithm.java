//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();
        int prime = 101; // A prime number for hashing
        int patternLength = pattern.length();
        int textLength = text.length();
        
        // Compute hash value for the pattern
        int patternHash = hashString(pattern, prime);
        
        // Compute hash value for the first window of text
        int textHash = hashString(text.substring(0, patternLength), prime);
        
        // Iterate through the text
        for (int i = 0; i <= textLength - patternLength; i++) {
            // Check if hash values match and if substrings are equal
            if (textHash == patternHash && text.substring(i, i + patternLength).equals(pattern)) {
                result.add(i + 1); // Add index (1-based) to result list
            }
            
            // Recompute hash value for the next window
            if (i < textLength - patternLength) {
                textHash = recomputeHash(text, i, i + patternLength, textHash, patternLength, prime);
            }
        }
        
        return result;
    }
    
    private int hashString(String s, int prime) {
        // Compute hash value for string using rolling hash
        int hashVal = 0;
        for (char c : s.toCharArray()) {
            hashVal = (hashVal * 256 + (int) c) % prime;
        }
        return hashVal;
    }
    
    private int recomputeHash(String text, int oldIndex, int newIndex, int oldHash, int patternLength, int prime) {
        // Recompute hash value when shifting window
        int newHash = (oldHash - text.charAt(oldIndex) * pow(256, patternLength - 1, prime)) * 256 + text.charAt(newIndex);
        return (newHash % prime + prime) % prime; // Ensure positive hash value
    }
    
    private int pow(int base, int exponent, int modulus) {
        // Calculate base^exponent % modulus using modular exponentiation
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent /= 2;
        }
        return result;
    }
}