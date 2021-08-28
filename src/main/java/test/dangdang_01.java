package test;

import java.util.Scanner;

public class dangdang_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp_str = sc.nextLine().split(",");
        int k = Integer.parseInt(sc.nextLine());
        long[] nums = new long[tmp_str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(tmp_str[i]);
        }
        System.out.println(run(nums,0,nums.length-1,k));
    }

    private static long run(long[] nums, int low, int high, int k){
        int pat = quickOne(nums,low,high);
        int index = pat - low + 1;
        if (index == k){
            return nums[pat];
        }
        else if(k < index){
            return run(nums,low,pat-1,k);
        }
        else
            return run(nums,pat+1,high,k-index);
    }

    private static int quickOne(long[] nums,int low, int high){
        long key = nums[low];
        while (low < high){
            while (low < high &&nums[high] <= key)
                high --;
            nums[low] = nums[high];
            while (low < high && nums[low] >= key)
                low++;
            nums[high] = nums[low];
        }
        nums[high] = key;
        return high;
    }
}
