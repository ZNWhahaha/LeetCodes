package hj;

import java.util.Scanner;

public class hj_57 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String num1 = in.nextLine();
            String num2 = in.nextLine();
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            int len_num1 = num1.length();
            int len_num2 = num2.length();
            for (; len_num1 > 0 || len_num2 > 0 ; len_num1--,len_num2--) {
                int tmp = 0;
                if (len_num1 > 0 && len_num2 > 0)
                    tmp = (num1.charAt(len_num1-1) - '0') + (num2.charAt(len_num2-1) - '0');
                else if (len_num1 <= 0)
                    tmp = num2.charAt(len_num2-1) - '0';
                else if (len_num2 <= 0)
                    tmp = num1.charAt(len_num1-1) - '0';
                if (flag){
                    tmp += 1;
                    flag = false;
                }
                sb.insert(0, tmp%10);
                if (tmp >= 10)
                    flag = true;
            }
            if (flag == true)
                sb.insert(0,1);
            System.out.println(sb.toString());
        }
    }
}
