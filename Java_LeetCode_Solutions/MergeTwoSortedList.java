/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode wrk = head;
        
        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                wrk.next = p1;
                p1 = p1.next;
            } else {
                wrk.next = p2;
                p2 = p2.next;
            }
            wrk = wrk.next;
        }
        
        if(p1 != null) {
            wrk.next = p1;
        }
        if(p2 != null) {
            wrk.next = p2;
        }
        return head.next;
    }
}