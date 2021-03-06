/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
	    
	    if(a == null || a.next == null){
	        return a;
	    }
	    ListNode current = a,next=null;
	    while(current!=null){
	        next = current.next;
	         while(next!=null && current.val==next.val){
	             current.next = next.next;
	             next = current.next;
	         }
	         current = current.next;
	    }
	    return a;
	}
}
