/*

Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,

reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

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
	public ListNode reorderList(ListNode a) {
	    
	    if(a == null || a.next == null ||a.next.next == null){
	        return a;
	    }
	    ListNode head1 = a,head2 = null, prev = null,temp = null, curr = null,result = a;
	    ListNode fast = a,slow = a,temp1 = null, temp2 = null;
	    while(fast.next!=null && fast.next.next!=null){
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    
	    curr = slow.next;
	    slow.next = null;
	    while(curr!=null){
	        temp = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = temp;
	    }
	    head2 = prev;
	    while(head2!=null){
	        temp1 = head1.next;
	        temp2 = head2.next;
	        head1.next = head2;
	        head2.next = temp1;
	        head1 = temp1;
	        head2 = temp2;
	    }
	    return result;
	}
}
