package LeetCode;

import java.util.Arrays;

public class code_shellSort {

    //希尔排序,又叫缩小增量排序
    private int[] shellSort(int[] arr){
        int len = arr.length;
        for (int gap = len / 2; gap > 0 ; gap = gap /2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j-gap >= 0 && current < arr[j-gap]){
                    arr[j] = arr[j-gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        code_shellSort cs = new code_shellSort();
        int[] nums = {2,4,8,1,5,3,9,1};
        System.out.println(Arrays.toString(nums));
        cs.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
