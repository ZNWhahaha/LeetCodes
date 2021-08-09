package test;

import java.util.Scanner;

public class meituan_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int result = 0;
        int more;
        for (int i = 1; i < n; i++) {
            more = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && more < nums[j])
                    more = nums[j];
            }
            result += (i+1) * more;
        }
        System.out.println(result);
    }
}
