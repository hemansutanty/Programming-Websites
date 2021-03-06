/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

    Notes:

        If the two linked lists have no intersection at all, return null.
        The linked lists must retain their original structure after the function returns.
        You may assume there are no cycles anywhere in the entire linked structure.
        Your code should preferably run in O(n) time and use only O(1) memory.

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
    
    public int getSize(ListNode a){
        int count = 0;
        while(a!=null){
            count++;a=a.next;
        }
        return count;
    }
    public ListNode findIntersection(ListNode a, ListNode b, int diff){
        int i=0;
       
        while(i<diff){
            a=a.next;i++;
        }
        while(a!=null && b!=null && !a.equals(b)){
            a=a.next;b=b.next;
        }
        
        return a;
    }
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
	    
	    int aLength = getSize(a), bLength = getSize(b);
	    int diff;
	    ListNode result = null;
	    if(aLength>bLength){
	        diff = aLength-bLength;
	        result = findIntersection(a,b,diff);
	    }
	    else{
	        diff = bLength-aLength;
	        result = findIntersection(b,a,diff);
	    }
	    
	    return result;
	}
}
