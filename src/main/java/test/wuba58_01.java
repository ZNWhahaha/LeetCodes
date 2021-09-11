package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wuba58_01 {
//    boolean[] used;
//    int result = 0;
//    int path = 0;
//    int start;
//    public int[] subArraySum (int[] Array, int arrayLen, int subArrayLen) {
//        // write code here
//        used = new boolean[arrayLen];
//
//    }
//
//    private void travel(int[] nums, int startIndex, int subArrayLen, int deep){
//        result = Math.max(result,path);
//        if (startIndex >= nums.length || deep > subArrayLen)
//            return;
//        for (int i = startIndex; i < nums.length; i++) {
//            if (i>0 && nums[i] == nums[i-1] && !used[i-1])
//                continue;
//            path += nums[i];
//            used[i] = true;
//            travel(nums,i+1,subArrayLen,deep+1);
//            path -= nums[i];
//            used[i] = false;
//        }
//    }

    public static int[] subArraySum (int[] Array, int arrayLen, int subArrayLen) {
        // write code here
        int[] tmp = Arrays.copyOf(Array,Array.length);
        Arrays.sort(tmp);
        List<Integer> path = new ArrayList<>();
        int[] result = new int[2];
        for (int i = arrayLen-1; i >= 0 && subArrayLen > 0; i--) {
            path.add(tmp[i]);
            subArrayLen--;
        }
        for (int i = 0; i < arrayLen; i++) {
            if (path.contains(Array[i])) {
                result[0] = i;
                break;
            }
        }
        for (int i : path)
            result[1] += i;
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 30, 4, 5, 6, 7, 8, 9, 10};
        int[] res = subArraySum(A,10,3);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
