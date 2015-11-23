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
        ListNode wrk = head.next;
        if(head.val == wrk.val) {
            while(wrk.next != null && wrk.val == head.val) {
                wrk = wrk.next;
            }
            if(wrk.next == null && wrk.val == head.val) {
                return null;
            }
            head = wrk;
            return deleteDuplicates(head);
        } else {
            wrk = head;
            while(wrk.next != null) {
                if(wrk.next.next != null && wrk.next.val != wrk.next.next.val) {
                    wrk = wrk.next;
                    continue;
                } else if(wrk.next.next == null) {
                    return head;
                } else {
                    ListNode tmp = wrk.next;
                    while(tmp.next != null && tmp.next.val == tmp.val) {
                        tmp = tmp.next;
                    }
                    if(tmp.next == null) {
                        wrk.next = null;
                        return head;
                    } else {
                        wrk.next = tmp.next;
                        continue;
                    }
                }
            }
            return head;
        }
    }
}