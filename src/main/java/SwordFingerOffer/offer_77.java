package SwordFingerOffer;

public class offer_77 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode L = sortList(head);
        ListNode R = sortList(head2);
        return merge(L, R);
    }

    private ListNode mergeSort(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode L = mergeSort(head);
        ListNode R = mergeSort(head2);
        return merge(L, R);
    }

    private ListNode merge(ListNode l, ListNode r){
        ListNode dummy = new ListNode(-1);
        ListNode x = dummy;
        while (l != null && r != null){
            if (l.val < r.val){
                x.next = l;
                l = l.next;
            }
            else {
                x.next = r;
                r = r.next;
            }
            x = x.next;
        }
        if (l != null)
            x.next = l;
        if (r != null)
            x.next = r;
        return dummy.next;
    }
}
