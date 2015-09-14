/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || k == 0 || k == 1) {
			return head;
		}
		ListNode wrk = new ListNode(0);
		wrk.next = head;
		ListNode itr = wrk;
		while(itr.next != null) {
			itr.next = reverseK(itr.next, k);
			for(int i = 0; i < k; i++) {
				if(itr.next == null) {
					return wrk.next;
				} else if(i == k) {
					break;
				}
				itr = itr.next;
			}
		}
		return wrk.next;
	}
	public static ListNode reverseK(ListNode input, int m) {
		if(input == null || m == 0 || m == 1) {
			return input;
		}
		if(m == 2) {
			return reverseTwo(input);
		}
		ListNode itr = input;
		for(int i = 0; i < m; i++) {
			if(itr == null) {
				return input;
			}
			itr = itr.next;
		}
		input.next = reverseK(input.next, m - 2);
		ListNode wrk = new ListNode(0);
		wrk.next = input;
		itr = wrk;
		System.out.println("itr: " + input.val);
		for(int i = 0; i < m; i++) {
			if(itr.next == null) {
				return input;
			} else if(i == m - 1) {
				break;
			}
			itr = itr.next;
		}
		System.out.println("");
		ListNode tmp1 = wrk;
		ListNode tmp2 = wrk.next;
		tmp1.next = itr.next;
		ListNode tmp3 = itr.next.next;
		tmp1.next.next = tmp2.next;
		tmp2.next = tmp3;
		itr.next = tmp2;

		return wrk.next;
	}
	public static ListNode reverseTwo(ListNode head) {
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
			break;
		}
		return wrk.next;
	}
}