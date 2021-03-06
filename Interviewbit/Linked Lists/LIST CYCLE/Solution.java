/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 

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
	public ListNode detectCycle(ListNode a) {
	    
	    ListNode slow = a, fast = a,result = null;
	    while(fast.next!=null && fast.next.next!=null){
	        slow = slow.next;
	        fast = fast.next.next;
	        if(slow.equals(fast)){
	            slow = a;
	            while(!slow.equals(fast)){
	                slow = slow.next;
	                fast = fast.next;
	            }
	            result = slow;
	            break;
	        }
	    }
	    return result;
	}
}
