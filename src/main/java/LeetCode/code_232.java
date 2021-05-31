package LeetCode;

//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

import java.util.ArrayDeque;
import java.util.Stack;

public class code_232 {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    /** Initialize your data structure here. */
    public code_232() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
