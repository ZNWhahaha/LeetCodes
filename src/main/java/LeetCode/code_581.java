package LeetCode;

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//        请你找出符合题意的 最短 子数组，并输出它的长度。

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class code_581 {
    //排序
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != snums[i]){
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }

    //使用栈
    public int findUnsortedSubarray_1(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int start = nums.length;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                start = Math.min(start,stack.pop());
            stack.push(i);
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                end = Math.max(end,stack.pop());
            stack.push(i);
        }

        return end - start >= 0 ? end - start + 1 : 0;
    }
}
