/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null || (head.next.next == null && head.next.val >= x)) {
            return head;
        }
        if(head.next.next == null && head.next.val < x) {
            if(head.val >= x) {
                ListNode tmp = new ListNode(head.val);
                head = head.next;
                head.next = tmp;
            }
            return head;
        }
        ListNode prt = head;
        ListNode tmp = head;
        ListNode pre = head;
        if(prt.val >= x) {
            while(tmp.next != null && tmp.next.val >= x) {
                tmp = tmp.next;
            }
            if(tmp.next == null && tmp.val >= x) {
                return head;
            }
            ListNode newTmp = new ListNode(tmp.next.val);
            if(tmp.next.next != null) {
                tmp.next = tmp.next.next;
            } else {
                tmp.next = null;
            }
            head = newTmp;
            head.next = prt;
            pre = head;
        } else {
            prt = prt.next;
            while(prt.next != null && prt.val < x) {
                prt = prt.next;
                pre = pre.next;
            }
            if(prt.next == null && prt.val < x) {
                return head;
            }
            tmp = prt;
        }
        while(tmp.next != null) {
            if(tmp.next.val >= x) {
                tmp = tmp.next;
            } else {
                ListNode newTmp = new ListNode(tmp.next.val);
                if(tmp.next.next != null) {
                    tmp.next = tmp.next.next;
                } else {
                    tmp.next = null;
                }
                newTmp.next = prt;
                pre.next = newTmp;
                pre = pre.next;
            }
        }
        return head;
    }
}