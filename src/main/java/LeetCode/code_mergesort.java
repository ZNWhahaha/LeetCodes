package LeetCode;

import java.lang.ref.SoftReference;
import java.util.Arrays;

public class code_mergesort {

    private void mergeSort(int[] arr){
        int[] tmp = new int[arr.length];
        doSort(arr, tmp, 1, arr.length);
    }

    private void doSort(int[] arr, int[] tmp, int begin, int end){
        if (begin == end)
            tmp[begin-1] = arr[begin-1];
        else{
            int middle = (begin + end) / 2;
            doSort(arr, tmp, begin, middle);
            doSort(arr, tmp, middle + 1, end);
            doMerge(tmp, arr, begin, middle, end);
            System.arraycopy(arr, begin - 1, tmp, begin - 1, (end - begin) + 1);
        }
        
    }

    public static void doMerge(int[] from, int[] to, int begin, int middle, int end) {
        int index = begin;
        int position = middle + 1;
        while (begin <= middle && position <= end) {
            if (from[begin - 1] < from[position - 1]) {
                to[index - 1] = from[begin - 1];
                begin++;
            } else {
                to[index - 1] = from[position - 1];
                position++;
            }
            index++;
        }
        while (begin <= middle) {
            to[index - 1] = from[begin - 1];
            begin++;
            index++;
        }
        while (position <= end) {
            to[index - 1] = from[position - 1];
            position++;
            index++;
        }
    }

    public static void main(String[] args) {
        code_mergesort cm = new code_mergesort();
        int[] nums = {2,4,8,1,5,3,9,1};
        System.out.println(Arrays.toString(nums));
        cm.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
