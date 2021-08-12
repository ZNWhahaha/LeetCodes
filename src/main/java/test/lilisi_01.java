package test;

public class lilisi_01 {


    private class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode formatList(ListNode head) {
        // write code here
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null){
            ListNode tmp = head.next;
            head.next = null;
            tmp.next = head;
            return tmp;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode cath = null;
        ListNode tmp = null;
        int flag = 0;
        while (cur.next != null){
            if (flag % 2 == 0){
                cath = cur;
                cur = cur.next;
            }
            else {
                tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cath.next = tmp;
                cur = tmp;
            }
            flag += 1;
        }
        return pre;
    }
}
