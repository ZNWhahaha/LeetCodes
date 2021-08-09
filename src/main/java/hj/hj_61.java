package hj;

import java.util.Scanner;

public class hj_61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(count(a,b));
        }
    }

    public static int count(int a,int b){
        if (a < 0 || b < 0)
            return 0;
        else if (a == 1 || b == 1)
            return 1;
        else
            return count(a,b - 1) + count(a - b,b);
    }
}
