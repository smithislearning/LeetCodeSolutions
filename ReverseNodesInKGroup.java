class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode input = new ListNode(1);
		input.next = new ListNode(2);
		input.next.next = new ListNode(3);
		input.next.next.next = new ListNode(4);
		input.next.next.next.next = new ListNode(5);
		input.next.next.next.next.next = new ListNode(6);
		input.next.next.next.next.next.next = new ListNode(7);
		ListNode tmp = input;
		while(tmp != null) {
			System.out.print(tmp.val + ", ");
			tmp = tmp.next;
		}
		System.out.println("");
		ListNode output = reverseKGroup(input, 4);
		tmp = output;
		System.out.println("output: ");
		while(tmp != null) {
			System.out.print(tmp.val + ", ");
			tmp = tmp.next;
		}
		System.out.println("");
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
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
		System.out.println("working");
		if(input == null || m == 0 || m == 1) {
			return input;
		}
		if(m == 2) {
			return reverseTwo(input);
		}
		input.next = reverseK(input.next, m - 2);
		ListNode wrk = new ListNode(0);
		wrk.next = input;
		ListNode itr = wrk;
		System.out.println("itr: " + input.val);
		for(int i = 0; i < m; i++) {
			System.out.print(itr.val + ", ");
			if(itr.next == null) {
				System.out.println("");
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
		ListNode tmp = tmp1;
		System.out.println("tmp1: ");
		while(tmp != null) {
			System.out.print(tmp.val + ", ");
			tmp = tmp.next;
		}
		System.out.println("");
		tmp = tmp2;
		System.out.println("tmp2: ");
		while(tmp != null) {
			System.out.print(tmp.val + ", ");
			tmp = tmp.next;
		}
		System.out.println("");
		System.out.println("end");
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