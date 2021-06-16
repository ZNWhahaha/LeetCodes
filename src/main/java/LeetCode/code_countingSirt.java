package LeetCode;

import java.util.Arrays;

public class code_countingSirt {
    //计数排序
    private int[] countingSort(int[] arr,int maxValue){
        int[] bucket = new int[maxValue+1];
        int sortINdex = 0;

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        for (int i = 0; i < maxValue+1; i++) {
            while (bucket[i] > 0){
                arr[sortINdex++] = i;
                bucket[i]--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        code_countingSirt cc = new code_countingSirt();
        int[]  nums = {2,4,8,1,5,3,9,1};
        System.out.println(Arrays.toString(nums));
        cc.countingSort(nums,9);
        System.out.println(Arrays.toString(nums));
    }

}
