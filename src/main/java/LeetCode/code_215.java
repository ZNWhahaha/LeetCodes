package LeetCode;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

import java.util.Arrays;
import java.util.PriorityQueue;

public class code_215 {

    // 优先队列（最小堆）
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> head = new PriorityQueue<>();
        for (int num : nums){
            head.add(num);
            if (head.size() > k)
                head.poll();
        }
        return head.peek();
    }

    // 快排的partition
    public int findKthLargest_1(int[] nums, int k){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true){
            int index = partition(nums,left,right);
            if (index == target)
                return nums[index];
            else if (index < target)
                left = index + 1;
            else if (index > target)
                right = index - 1;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int j = left;
        for (int i = left+1; i < nums.length; i++) {
            if (nums[i] < pivot){
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums, j, left);
        return j;
    }
}
