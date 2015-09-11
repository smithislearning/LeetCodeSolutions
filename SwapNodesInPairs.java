/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode wrk = head;
        if(wrk == null || wrk.next == null) {
            return wrk;
        }
        while(wrk != null && wrk.next != null) {
            int tmpVal = wrk.next.val;
            wrk.next.val = wrk.val;
            wrk.val = tmpVal;
            wrk = wrk.next.next;
        }
        wrk = head;
        return wrk;
    }
}