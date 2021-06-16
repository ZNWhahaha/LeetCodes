package LeetCode;

import java.util.Arrays;

public class code_bubblesort {
    //冒泡排序
    private void bubblesort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1; j++) {
                if (nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        code_bubblesort bubblesort = new code_bubblesort();
        int[] nums = {2,4,8,1,5,3,9,1};
        System.out.println(Arrays.toString(nums));
        bubblesort.bubblesort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
