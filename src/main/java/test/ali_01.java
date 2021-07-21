package test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ali_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums = new long[n];
        nums[0] = in.nextInt();

        for (int i = 1; i < n; i++) {
            nums[i] = in.nextInt();
            long tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
        }
        for (long a : nums)
            System.out.print(a + " ");

    }
    private static void resever(int[] nums,int index){
        int l = 0;
        int r = index;
        while (l < r){
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l] ^= nums[r];
            l++;
            r--;
        }
    }
}
