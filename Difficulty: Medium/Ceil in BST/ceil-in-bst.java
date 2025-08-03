/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Tree {
    int findCeil(Node root, int key) {
        // code here
        int ceilValue = -1;
        if(root == null) return ceilValue;
        if(root.data == key) return root.data;
        while(root!=null){
            if(root.data>=key){
                ceilValue = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceilValue;
    }
}