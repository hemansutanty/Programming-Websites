/*

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ≤ m ≤ n ≤ length of list.

    Note 2:
    Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question. 


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
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    
	    if(m==n){
	        return a;
	    }
	    ListNode head = a;
	    ListNode prev=null,temp=null,currRun=null,prevRun=null,curr=null;
	    int i=1;
	    while(i<m){
	        prev = a;
	        a=a.next;
	        i++;
	    }
	    curr = a;
	    prevRun = null;
	    currRun = a;
	    while(i<=n){
	        temp = currRun.next;
	        currRun.next = prevRun;
	        prevRun = currRun;
	        currRun = temp;
	        i++;
	    }
	    curr.next = temp;
	    if(prev!=null){
	        prev.next = prevRun;
	        return head;
	    }
	    else{
	        return prevRun;
	    }
	}
}

