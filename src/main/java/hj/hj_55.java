package hj;

import java.util.Scanner;

public class hj_55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String tmp = in.nextLine();
            int num = Integer.parseInt(tmp);
            int result = 0;
            for (int i = 1; i <= num; i++) {
                if (i % 7 == 0)
                    result += 1;
                else if (String.valueOf(i).contains("7"))
                    result += 1;
            }
            System.out.println(result);

        }
    }

}
