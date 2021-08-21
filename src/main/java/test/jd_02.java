package test;

import java.util.HashSet;
import java.util.Scanner;

public class jd_02 {
    public static int result = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new  int[3];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            nums[i] = in.nextInt();
            set.add(nums[i]);
        }

        sum(nums,n,0);

        System.out.println(result);
    }

    private static void sum(int[] nums, int n, int re){
        if (n < 0)
            return;
        result = Math.max(result,re);
        for (int i = 0; i < nums.length; i++) {
            sum(nums,n-nums[i],re+1);
        }
    }
}
