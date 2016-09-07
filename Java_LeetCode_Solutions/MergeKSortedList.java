/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode wrk = head;
        ListNode p1 = wrk.next;
        for(ListNode p2 : lists) {
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
            wrk = head;
            p1 = wrk.next;
        }
        return head.next;
    }
}