package hj;

import java.util.Scanner;

public class hj_46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] str = in.nextLine().toCharArray();
            int n = Integer.valueOf(in.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        }
    }
}
