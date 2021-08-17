package SwordFingerOffer;

import java.util.List;

public class offer_26 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode rightList = mid.next;
        mid.next = null;

        ListNode pre = null;
        ListNode cur = rightList;
        ListNode tmp = null;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        ListNode l = head;
        ListNode r = pre;
        while (r != null){
            ListNode lNext = l.next;
            ListNode rNext = r.next;
            r.next = l.next;
            l.next = r;
            l = lNext;
            r = rNext;
        }
    }
}
