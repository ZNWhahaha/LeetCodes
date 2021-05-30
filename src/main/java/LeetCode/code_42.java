package LeetCode;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

import java.util.Stack;

public class code_42 {
    public static int trap(int[] height) {
        if (height.length <= 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int cur = 0;
        while (cur < height.length){
            while (!stack.empty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = cur - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[cur]);
                result = result + distance * (min - h);
            }
            stack.push(cur);
            cur++;

        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(a);
    }
}
