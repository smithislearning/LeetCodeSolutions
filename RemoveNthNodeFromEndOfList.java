/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0) {
			return head;
		}
		ListNode wrk = head;
		int cnt = 0;
		while(wrk != null) {
			cnt++;
			wrk = wrk.next;
		}
		int pos = cnt - n + 1;
		if(pos == 1) {
			if(cnt > 1) {
				head = head.next;
				return head;
			} else {
				return null;
			}
		}
		cnt = 0;
		wrk = head;
		while(cnt < pos - 2) {
			cnt++;
			wrk = wrk.next;
		}
		wrk.next = wrk.next.next;
		wrk = head;
		return wrk;
	}
}