package LeetCode;

//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class code_225 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public code_225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
