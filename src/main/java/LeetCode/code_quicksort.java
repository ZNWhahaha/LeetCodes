package LeetCode;

import java.util.Arrays;

public class code_quicksort {

    private int[] quickSort(int[] arr,int left,int right){
        int partitionIndex;

        if (left < right){
            partitionIndex = patition(arr,left,right);
            quickSort(arr,left,partitionIndex-1);
            quickSort(arr,partitionIndex+1,right);
        }
        return arr;
    }

    private int patition(int[] arr,int left,int right){
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right ; i++) {
            if (arr[i] < arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);
        return index-1;
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        code_quicksort cq = new code_quicksort();
        int[]  nums = {3,2,5,1,6,4};
        System.out.println(Arrays.toString(nums));
        cq.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private void quciksort_1(int[] nums, int left, int right){
        int pa;
        while (left < right){
            pa = patation(nums,left,right);
            quciksort_1(nums,left,pa-1);
            quciksort_1(nums,pa+1,right);
        }
    }

    private int patation(int[] nums, int left, int right){
        int poivt = left;
        int index = poivt + 1;
        for (int i = index; i < right; i++) {
            if (nums[i] < nums[poivt]){
                swap_h(nums,i,index);
                index++;
            }
        }
        swap_h(nums,index,poivt);
        return index-1;
    }

    private void swap_h(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
