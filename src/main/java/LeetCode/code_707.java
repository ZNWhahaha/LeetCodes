package LeetCode;

import java.util.LinkedList;

public class code_707 {
    public class MyLinkedList {
        private class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next, ListNode prev) {
                this.val = val;
                this.next = next;
            }
        }

        int size;
        ListNode head;
        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index > size)
                return -1;
            ListNode cur = head.next;
            while (index-- > 0){
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode newnode = new ListNode(val);
            newnode.next = head.next;
            head.next = newnode;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode newnode = new ListNode(val);
            ListNode cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = newnode;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size)
                return;
            ListNode newnode = new  ListNode(val);
            ListNode cur = head;
            while (index-- > 0){
                cur = cur.next;
            }
            newnode.next = cur.next;
            cur.next = newnode;
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;
            ListNode cur = head;
            while (index-- > 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }
}
