/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        if(head == null || head.next == null) return 0;
        Node slow = head;
        Node fast = head;
        int cnt = 0;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return loopLength(slow,fast);
        }
        return 0;
    }
    public int loopLength(Node slow, Node fast){
        int cnt = 1;
        fast = fast.next;
        while(slow!=fast){
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }
}