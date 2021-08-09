package test;

import java.util.Arrays;
        import java.util.Scanner;

public class meituan_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int time = Integer.parseInt(in.nextLine());
        for (int i = 0; i < time; i++) {
            String tmp = in.nextLine();
            String tmp_nums = in.nextLine();
            int n = Integer.parseInt(tmp.split(" ")[0]);
            int k = Integer.parseInt(tmp.split(" ")[1]);
            String[] nums_str = tmp_nums.split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(nums_str[j]);
            }
            Arrays.sort(nums);
            int result = 0;
            for (int j = 1; j <= n ; j++) {
                if (j > nums[k-1] && j<= nums[k]){
                    result = j;
                    break;
                }
            }
            if (result != 0){
                System.out.println("YES");
                System.out.println(result);
            }
            else
                System.out.println("NO");
        }
    }
}
