package test;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class jd_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String tmp = in.nextLine();
        char[] nums_ch = tmp.toCharArray();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nums_ch[i] - '0';
        }

        int[] result = new int[n];
        Arrays.fill(result,1);
        for (int i = 1; i < n; i++) {
            int re = 0;
            for (int j = 1; j <= i; j++) {
                if (check(nums,0,j-1,j,i)){
                    re += 1;
                }
            }
            result[i] += re;
        }
        for (int i = 0; i < n-1; i++) {
            System.out.print(result[i]+ " ");
        }
        System.out.println(result[n-1]);

    }

    private static boolean check(int[] nums,int start_a,int end_a,int start_b,int end_b){
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        for (int i = start_a; i <= end_a; i++) {
            if (nums[i] == 0)
                A += 1;
            else if (nums[i] == 1)
                B += 1;
        }
        for (int i = start_b; i <= end_b; i++) {
            if (nums[i] == 0)
                C += 1;
            else if (nums[i] == 1)
                D += 1;
        }
        return A*D == B*C;
    }
}
