/*


Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3


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
	public ListNode insertionSortList(ListNode a) {
	    
	    if (a == null || a.next == null)
			return a;
 
		ListNode newHead = new ListNode(a.val);
		ListNode p1 = a.next;
		while (p1 != null) {
			ListNode p2 = newHead;
			ListNode next = p1.next;
 
			if (p1.val <= newHead.val) {
				ListNode oldHead = newHead;
				newHead = p1;
				newHead.next = oldHead;
			} 
			else {
				while (p2.next != null) {
					if (p1.val > p2.val && p1.val <= p2.next.val) {
						ListNode oldNext = p2.next;
						p2.next = p1;
						p1.next = oldNext;
					}
					p2 = p2.next;
				}
				if (p2.next == null && p1.val > p2.val) {
					p2.next = p1;
					p1.next = null;
				}
			}
			p1 = next;
		}
		return newHead;
	}
}
