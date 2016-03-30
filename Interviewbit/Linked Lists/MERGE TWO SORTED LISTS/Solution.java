/*

Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15

The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20


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
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
	    
	    ListNode result = new ListNode(0);
	    ListNode p1 = a, p2 = b,current=result;
	    while(p1!=null && p2!=null){
	        if(p1.val<p2.val){
	            current.next = p1;
	            p1 = p1.next;
	        }
	        else{
	            current.next = p2;
	            p2 = p2.next;
	        }
	        current = current.next;
	    }
	    if(p1!=null){
	        current.next = p1;
	    }
	    if(p2!=null){
	        current.next = p2;  
	    }
	    return result.next;
	}
}
