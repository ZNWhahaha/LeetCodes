package LeetCode;

//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
//        请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
//        nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。


import java.util.*;

public class code_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer,Integer> map = nextGreaterHelp(nums2);

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    private Map<Integer,Integer> nextGreaterHelp(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums.length-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            map.put(nums[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums[i]);
        }
        return map;
    }

    public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = nums2.length-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i])
                stack.pop();
            map.put(nums2[i],stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        
        return result;
    }
}
