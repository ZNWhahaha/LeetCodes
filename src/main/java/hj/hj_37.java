package hj;

import java.util.Scanner;

public class hj_37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int time = in.nextInt();
            int a = 1;
            int b = 1;
            int c = 1;
            for (int i = 2; i < time; i++) {
                c = a+b;
                a = b;
                b = c;
            }
            System.out.print(c);
        }
    }
}
