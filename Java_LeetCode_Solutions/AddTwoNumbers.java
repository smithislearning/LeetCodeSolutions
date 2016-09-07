/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        ListNode tmpA = result;
        ListNode tmpB = l2;
        while(tmpA != null) {
            if(tmpB == null) {
                tmpB = new ListNode(0);
            }
            int tmp = tmpA.val + tmpB.val;
            tmpA.val = tmp % 10;
            if(tmp > 9) {
                if(tmpA.next == null) {
                    tmpA.next = new ListNode(tmp / 10);
                } else {
                    tmpA.next.val += tmp / 10;
                }
            } else if(tmpA.next == null && tmpB.next != null) {
                tmpA.next = new ListNode(0);
            }
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return result;
    }
}