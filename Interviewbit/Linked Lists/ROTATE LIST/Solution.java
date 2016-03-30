/*

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.


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
	public ListNode rotateRight(ListNode a, int b) {
	   
	   int size = getSize(a);
	   if(size==1 || b%size==0){
	       return a;
	   }
	   if(b>size)
	        b=b%size;
	    int i=1;
	    ListNode head = a,result,resultHead;
	    while(i<size-b){
	        head = head.next;
	        i++;
	    }
	    result = head.next;
	    resultHead = result;
	    head.next = null;
	    while(result.next!=null){
	        result=result.next;
	    }
	    result.next = a;
	    return resultHead;
	}
}
