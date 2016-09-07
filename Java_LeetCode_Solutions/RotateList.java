/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        int len = 1;
        ListNode end = head;
        while(end.next != null) {
            end = end.next;
            len++;
        }
        if(k % len == 0) {
            return head;
        }
        k = k % len;
        int point = 1;
        int gap = len - k;
        ListNode newEnd = head;
        while(point < gap) {
            newEnd = newEnd.next;
            point++;
        }
        ListNode newHead = newEnd.next;
        end.next = head;
        newEnd.next = null;
        return newHead;
    }
}