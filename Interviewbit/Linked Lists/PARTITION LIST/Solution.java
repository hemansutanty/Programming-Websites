/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.


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
	public ListNode partition(ListNode a, int b) {
	    
	    if(a==null || a.next == null){
	        return a;
	    }
	    ListNode head1 = new ListNode(0),head2 = new ListNode(0);
	    head1.next = a;
	    ListNode p1 = a, prev = head1, p2 = head2;
	    while(p1!=null){
	        if(p1.val<b){
	            p1 = p1.next;
	            prev = prev.next; 
	        }
	        else{
	            p2.next = p1;
	            prev.next = p1.next;
	            p1 = prev.next;
	            p2 = p2.next;
	        }
	    }
	    p2.next = null;
        prev.next = head2.next;
        return head1.next;
	}
}
