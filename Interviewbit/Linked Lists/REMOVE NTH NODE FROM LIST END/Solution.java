/*

Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

    Note:
    * If n is greater than the size of the list, remove the first node of the list. 

Try doing it using constant additional space.


*/


//Solution

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int sizeList(ListNode a){
        int count = 0;
        while(a!=null){
            count++;
            a=a.next;
        }
        return count;
    }
	public ListNode removeNthFromEnd(ListNode a, int b) {
	    
	    
	    int size = sizeList(a);
	    //System.out.println(size);
	    ListNode head = a;
	    if(size==1 && b>=1){
	        return null;
	    }
	    if(b>=size){
	        head=head.next;
	        return head;
	    }
	    else{
	        int i=1;
	        while(i<size-b){
	            head=head.next;
	            i++;
	        }
	        head.next=head.next.next;
	       
	    }
	    return a;
	    
	}
}
