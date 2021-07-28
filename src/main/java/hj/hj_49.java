package hj;

import java.util.Scanner;

public class hj_49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                sb.append("ABCD");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
