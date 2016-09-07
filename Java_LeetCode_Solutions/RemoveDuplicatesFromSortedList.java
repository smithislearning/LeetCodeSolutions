/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode wrk = head;
        while(wrk.next != null) {
            if(wrk.next.val != wrk.val) {
                wrk = wrk.next;
                continue;
            } else {
                ListNode tmp = wrk.next;
                while(tmp.next != null && tmp.val == wrk.val) {
                    tmp = tmp.next;
                }
                if(tmp.val == wrk.val && tmp.next == null) {
                    wrk.next = null;
                    return head;
                } else {
                    wrk.next = tmp;
                }
            }
        }
        return head;
    }
}