//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
     
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        if (head == null || head.next == null)
            return head; // Empty list or single node
        
        Node dummyAscending = new Node(0); // Dummy node for ascending list
        Node dummyDescending = new Node(0); // Dummy node for descending list
        
        Node currentAscending = dummyAscending;
        Node currentDescending = dummyDescending;
        Node current = head;
        
        boolean isAscending = true;
        
        while (current != null) {
            if (isAscending) {
                currentAscending.next = current;
                currentAscending = currentAscending.next;
            } else {
                currentDescending.next = current;
                currentDescending = currentDescending.next;
            }
            isAscending = !isAscending;
            current = current.next;
        }
        
        // Mark the end of both lists
        currentAscending.next = null;
        currentDescending.next = null;
        
        // Reverse the descending list
        Node reversedDescending = reverseLinkedList(dummyDescending.next);
        
        // Merge the two sorted lists
        return mergeLinkedLists(dummyAscending.next, reversedDescending);
    }
    
    // Helper function to reverse a linked list
    private Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    // Helper function to merge two sorted linked lists
    private Node mergeLinkedLists(Node head1, Node head2) {
        Node dummy = new Node(0); // Dummy node to start the merged list
        Node current = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes
        if (head1 != null)
            current.next = head1;
        if (head2 != null)
            current.next = head2;
        
        return dummy.next;
   }
}