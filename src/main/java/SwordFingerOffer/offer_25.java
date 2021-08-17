package SwordFingerOffer;

import java.util.List;

public class offer_25 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode l1_re = reverseList(l1);
        ListNode l2_re = reverseList(l2);
        
        int tmp = 0;
        ListNode result = new ListNode(0);
        ListNode resultt = result;
        while (l1_re != null || l2_re != null){
            tmp = tmp + (l1_re == null ? 0 : l1_re.val) + (l2_re == null ? 0 : l2_re.val);
            result.next = new ListNode(tmp % 10);
            l1_re = (l1_re == null ? null : l1_re.next);
            l2_re = (l2_re == null ? null : l2_re.next);
            result = result.next;
            tmp /= 10;
        }
        if(tmp != 0){
            result.next =new ListNode(tmp);
        }
        return reverseList(resultt.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
