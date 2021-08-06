package hj;

import java.util.Arrays;
import java.util.Scanner;

public class hj_58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String tmp_1 = in.nextLine();
            String[] nums = in.nextLine().split(" ");
            int k = Integer.parseInt(tmp_1.split(" ")[1]);
            StringBuilder sb = new StringBuilder();
            int[] res = new int[nums.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = Integer.parseInt(nums[i]);
            }
            Arrays.sort(res);
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < k; i++) ans.append(res[i]).append(" ");
            System.out.println(ans.toString().trim());
        }
    }
}
