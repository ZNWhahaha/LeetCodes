package LeetCode;

import java.util.Arrays;

public class code_insertionSort {

    //插入排序
    private int[] insertionSort(int[] arr){
        int len = arr.length;
        int preIndex,current;
        for (int i = 1; i < len; i++) {
            preIndex = i-1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current){
                arr[preIndex+1] = arr[preIndex];
                preIndex --;
            }
            arr[preIndex+1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
        code_insertionSort ci = new code_insertionSort();
        int[] nums = {2,4,8,1,5,3,9,1};
        System.out.println(Arrays.toString(nums));
        ci.insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
