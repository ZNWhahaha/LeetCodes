package SwordFingerOffer;

public class offer_29 {
    private class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null){
            head =  new Node(insertVal);
            head.next = head;
            return head;
        }

        if (head.next == null){
            Node n = new Node(insertVal);
            head.next = n;
            n.next = head;
            return head;
        }

        Node more = head;
        Node less = head.next;
        while (true){
            if (less.val >= insertVal && more.val <= insertVal){
                more.next = new Node(insertVal,less);
                return head;
            }
            if (more.val > less.val){
                if (more.val < insertVal){
                    more.next = new Node(insertVal,less);
                    return head;
                }
                else if (more.val >= insertVal && insertVal <= less.val){
                    more.next = new Node(insertVal,less);
                    return head;
                }
            }
            more = less;
            less = less.next;


            if (more == head)
                break;
        }
        more.next = new Node(insertVal,less);
        return head;
    }
}
