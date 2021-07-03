package hj;

import java.util.Arrays;
import java.util.Scanner;

public class hj_34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String sent = in.nextLine();
            char[] tmp = sent.toCharArray();
            Arrays.sort(tmp);
            System.out.println(String.valueOf(tmp));
        }
    }
}
