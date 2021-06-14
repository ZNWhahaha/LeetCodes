package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class code_155 {
    /** initialize your data structure here. */
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public code_155() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class MinStack {

    Integer min = null;
    Stack<Long> data = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (data.isEmpty()) {
            data.push(0L);
            min = x;
        } else {
            //如果x是最小的数，这里可能越界，所以用Long来保存
            data.push(Long.valueOf(x) - min);
            min = Math.min(x, min);
        }
    }

    public void pop() {
        Long diff = data.pop();
        if (diff >= 0) {
            //return min + diff;
        } else {
            int res = min;
            min = (int) (min - diff);
            //return res;
        }
    }

    public int top() {
        Long diff = data.peek();
        if (diff >= 0) {
            return (int) (min + diff);
        } else {
            return min;
        }
    }

    public int getMin() {
        return min;
    }
}

