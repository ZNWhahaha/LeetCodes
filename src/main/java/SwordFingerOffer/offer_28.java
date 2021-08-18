package SwordFingerOffer;

import java.util.Deque;
import java.util.LinkedList;

public class offer_28 {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int value,Node prev,Node next,Node child){
            this.val = value;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    public Node flatten(Node head) {
        if (head == null)
            return head;
        Node dummy = new Node(-1,null,null,null);
        Node pre = dummy;
        Deque<Node> stack = new LinkedList<>();
        stack.push(head);
        while (!stack.isEmpty()){
            Node tmp = stack.poll();
            tmp.prev = pre;
            pre.next = tmp;
            if (tmp.next != null)
                stack.push(tmp.next);
            if (tmp.child != null){
                stack.push(tmp.child);
                tmp.child = null;
            }
            pre = tmp;
        }

        dummy.next.prev = null;
        return dummy.next;
    }

    Node dum;

    public Node flatten_dfs(Node head) {
        if (head == null)
            return head;
        this.dum = new Node(-1,null,null,null);
        dfs(dum,head);
        dum.next.prev = null;
        return dum.next;
    }

    private Node dfs(Node pre, Node cur){
        if (cur == null)
            return pre;

        pre.next = cur;
        cur.prev = pre;

        Node nextHead = cur.next;
        Node tmp = dfs(cur,cur.child);
        cur.child = null;
        
        return dfs(tmp,nextHead);
    }
}
