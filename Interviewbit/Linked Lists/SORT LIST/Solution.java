/*

Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 2 -> 4 -> 5


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
    
    public ListNode merge(ListNode l, ListNode r) {
		ListNode p1 = l;
		ListNode p2 = r;
		ListNode head = new ListNode(100);
		ListNode pNew = head;
		while (p1 != null || p2 != null) {
			if (p1 == null) {
				pNew.next = new ListNode(p2.val);
				p2 = p2.next;
				pNew = pNew.next;
			} else if (p2 == null) {
				pNew.next = new ListNode(p1.val);
				p1 = p1.next;
				pNew = pNew.next;
			} else {
				if (p1.val < p2.val) {
					pNew.next = new ListNode(p1.val);
					p1 = p1.next;
					pNew = pNew.next;
				} else if (p1.val == p2.val) {
					pNew.next = new ListNode(p1.val);
					pNew.next.next = new ListNode(p1.val);
					pNew = pNew.next.next;
					p1 = p1.next;
					p2 = p2.next;
 
				} else {
					pNew.next = new ListNode(p2.val);
					p2 = p2.next;
					pNew = pNew.next;
				}
			}
		}
		return head.next;
	}
	public ListNode sortList(ListNode a) {
	    if(a==null || a.next==null){
	        return a;
	    }
	    ListNode left=a,right=null,slow=a,fast=a;
	    while(fast.next!=null && fast.next.next!=null){
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    right = slow.next;
	    slow.next = null;
	    ListNode h1 = sortList(left);
	    ListNode h2 = sortList(right);
	    ListNode merged = merge(h1,h2);
	    return merged;
	}
}
