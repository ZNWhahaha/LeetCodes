package LeetCode;

//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

import java.util.ArrayDeque;
import java.util.Deque;

public class code_85 {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int h = 0;
            for (int j = matrix.length-1; j >= 0 ; j--) {
                if (matrix[j][h] == '0')
                    break;
                h += 1;
            }
            heights[i] = h;
        }
        return largestRectangleArea(heights);
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();
        for (int i = n-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
