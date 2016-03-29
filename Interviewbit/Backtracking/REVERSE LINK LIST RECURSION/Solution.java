/*

Reverse a linked list using recursion.

Example :
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.

*/


// Solution

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    ListNode head = null;
	public ListNode reverseList(ListNode a) {
	    if(a.next==null){
	        head = a;
	        return head;
	    }
	    reverseList(a.next);
	    ListNode next = a.next;
	    next.next = a;
	    a.next = null;
	    return head;
	}
}
