package SwordFingerOffer;


public class offer_78 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        int n = lists.length;
        if (n == 0)
            return null;
        return merge_sort(lists, 0, n - 1);
    }

    public ListNode merge_sort(ListNode [] lists, int l, int r)
    {
        if (l == r)
            return lists[l];
        int mid = (l + r) / 2;
        ListNode L = merge_sort(lists, l, mid);
        ListNode R = merge_sort(lists, mid + 1, r);
        return merge(L, R);
    }

    public ListNode merge(ListNode a, ListNode b)
    {
        ListNode dummy = new ListNode(-1);
        ListNode x = dummy;
        while (a != null && b != null)
        {
            if (a.val < b.val)
            {
                x.next = a;
                a = a.next;
            }
            else
            {
                x.next = b;
                b = b.next;
            }
            x = x.next;
        }
        if (a != null)
            x.next = a;
        if (b != null)
            x.next = b;
        return dummy.next;
    }
}
