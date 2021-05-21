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
        int[]  nums = {2,4,8,1,5,3,9,1};
        System.out.println(Arrays.toString(nums));
        cq.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
