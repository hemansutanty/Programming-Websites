/*

Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:
- Expected solution is linear in time and constant in space.

For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.


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
    public int lPalin(ListNode A) {
        
        if(A==null || A.next==null)
            return 1;
        ListNode fast = A,slow = A;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode B = slow.next;
        slow.next = null;
        ListNode p1=B,p2=p1.next,temp;
        while(p1!=null && p2 !=null){
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        B.next = null;
        ListNode p = p2==null?p1:p2;
        ListNode q = A;
        while(p!=null){
            if(p.val!=q.val)
                return 0;
            p=p.next;
            q=q.next;
        }
        return 1;
    }
}
