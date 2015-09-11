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
        if(head == null || head.next == null) {
			return head;
		}
		ListNode wrk = new ListNode(0);
		wrk.next = head;
		ListNode tmp1 = wrk;
		ListNode tmp2 = wrk.next;
		while(tmp2 != null && tmp2.next != null) {
			tmp1.next = tmp2.next;
			tmp2.next = tmp2.next.next;
			tmp1.next.next = tmp2;
			tmp1 = tmp2;
			tmp2 = tmp2.next;
		}
		return wrk.next;
	}
}