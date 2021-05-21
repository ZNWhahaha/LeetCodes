package hj;

import java.util.Scanner;

public class hf_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            String[] nums = String.valueOf(a).split("");
            for (int i = nums.length-1; i >=0 ; i--) {
                System.out.print(nums[i]);
            }
        }
    }
}
