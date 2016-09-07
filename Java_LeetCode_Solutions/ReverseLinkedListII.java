/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m < 1 || m == n) {
            return head;
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ListNode fHead = new ListNode(0);
        fHead.next = head;
        ListNode wrk = fHead;
        int cnt = 0;
        while(cnt < m - 1) {
            wrk = wrk.next;
            cnt++;
        }
        ListNode tmpwrk = wrk.next;
        int tmpcnt = cnt + 1;
        while(tmpcnt < n + 1) {
            tmp.add(tmpwrk.val);
            tmpwrk = tmpwrk.next;
            tmpcnt++;
        }
        for(int i = tmp.size() - 1; i > -1; i--) {
            ListNode crntwrk = new ListNode(tmp.get(i));
            wrk.next = crntwrk;
            wrk = wrk.next;
        }
        wrk.next = tmpwrk;
        return fHead.next;
    }
}