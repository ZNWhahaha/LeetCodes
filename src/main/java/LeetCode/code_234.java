package LeetCode;

//请判断一个链表是否为回文链表。

public class code_234 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        ListNode prepre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null)
            slow = slow.next;
        while (pre != null && slow != null){
            if (pre.val != slow.val)
                return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
