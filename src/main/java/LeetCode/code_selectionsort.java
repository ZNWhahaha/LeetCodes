package LeetCode;

import java.util.Arrays;

public class code_selectionsort {

    private void selectionSort(int[] nums){
        int len = nums.length;
        int minIndex,tmp;

        for (int i = 0; i < len-1; i++) {
            minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (nums[j] > nums[minIndex])
                    minIndex = j;
            }
            tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void main(String[] args) {
        code_selectionsort selectionsort = new code_selectionsort();
        int[] nums = {2,4,8,1,5,3,9,1};
        System.out.println(Arrays.toString(nums));
        selectionsort.selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
