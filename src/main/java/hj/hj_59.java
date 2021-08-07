package hj;

import java.util.Scanner;

public class hj_59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String tmp = in.nextLine();
            char[] c = tmp.toCharArray();
            int time = 0;
            for (int i = 0; i < c.length; i++) {
                time = 0;
                for (int j = 0; j < c.length; j++) {
                    if (c[i] == c[j])
                        time ++;
                }
                if (time == 1){
                    System.out.println(c[i]);
                    break;
                }
            }
            if (time != 1)
                System.out.println(-1);
        }
    }
}
