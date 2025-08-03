// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        int floorValue = -1;
        if(root == null) return floorValue;
        if(root.data==x) return root.data;
        while(root!=null){
            if(root.data>x){
                root = root.left;
            }
            else{
                floorValue = root.data;
                root = root.right;
            }
        }
        return floorValue;
    }
}