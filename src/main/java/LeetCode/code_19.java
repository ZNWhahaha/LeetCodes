package LeetCode;

import java.util.List;

public class code_19 {

//    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//    进阶：你能尝试使用一趟扫描实现吗？

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode prev = dummy;
        while (n-- > 0){
            cur = cur.next;
        }
        while (cur.next != null){
            cur = cur.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
