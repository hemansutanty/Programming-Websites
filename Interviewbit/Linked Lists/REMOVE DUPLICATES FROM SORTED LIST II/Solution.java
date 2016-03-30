/*

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.


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
	public ListNode deleteDuplicates(ListNode a) {
	    
	    if(a==null || a.next==null){
	        return a;
	    }
	    ListNode t = new ListNode(0);
	    t.next = a;
	    int duplicate;
	    
	    ListNode current=t;
	    while(current.next!=null && current.next.next!=null){
	        if(current.next.val==current.next.next.val){
	            duplicate=current.next.val;
	            while(current.next!=null && current.next.val==duplicate){
	                current.next = current.next.next;
	            }
	        }
	        else{
	            current=current.next;
	        }
	    }
	    return t.next;
	    
	}
}
