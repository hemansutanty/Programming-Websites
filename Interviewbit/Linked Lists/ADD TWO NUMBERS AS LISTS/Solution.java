/*

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807

Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.

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
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    
	    int sum = 0,carry = 0,sumDig=0;
	    ListNode result = new ListNode(0),sumNode=null,head=result;
	    while(a!=null && b!=null){
	        sum = a.val+b.val+carry;
	        sumDig = sum%10;
	        carry = sum/10;
	        sumNode = new ListNode(sumDig);
	        result.next = sumNode;
	        a=a.next;b=b.next;result=result.next;
	    }
	    while(a!=null){
	        sum = a.val+carry;
	        sumDig = sum%10;
	        carry = sum/10;
	        sumNode = new ListNode(sumDig);
	        result.next = sumNode;
	        a=a.next;result=result.next;
	    }
	    while(b!=null){
	        sum = b.val+carry;
	        sumDig = sum%10;
	        carry = sum/10;
	        sumNode = new ListNode(sumDig);
	        result.next = sumNode;
	        b=b.next;result=result.next;
	    }
	    if(carry>0){
	        sumNode = new ListNode(carry);
	        result.next = sumNode;
	    }
	    return head.next;
	}
}
