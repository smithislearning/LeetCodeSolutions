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
        ListNode wrk = l1;
        while(wrk != null) {
            if(l2 == null) {
                break;
            } if(wrk.val == l2.val) {
                wrk.next.next = wrk.next;
                wrk.next = new ListNode(l2.val);
                wrk = wrk.next.next;
                l2 = l2.next;
            } else if(wrk.val < l2.val) {
                if(wrk.next == null) {
                    wrk.next = l2;
                } else if(wrk.next.val > l2.val) {
                    wrk.next.next = wrk.next;
                    wrk.next = new ListNode(l2.val);
                    wrk = wrk.next.next;
                    l2 = l2.next;
                } else {
                    wrk = wrk.next;
                }
            } else {
                wrk.next = wrk;
                wrk = new ListNode(l2.val);
                l2 = l2.next;
            }
        }
        wrk = l1;
        return wrk;
    }
}