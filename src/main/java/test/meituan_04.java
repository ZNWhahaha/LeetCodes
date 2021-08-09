package test;

import java.util.Scanner;

public class meituan_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < n/2 ; i++) {
            left += nums[i];
            right += nums[n-i-1];
        }
        
    }
}
