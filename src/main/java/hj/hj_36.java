package hj;

import java.util.Scanner;

public class hj_36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String code = in.nextLine();
            String tmp = in.nextLine();
            int[] stand = new int[26];
            int i;
            for (i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                if (c >= 'a' && c <= 'z')
                    stand[i] = c - 'a';
                else if (c >= 'A' && c <= 'Z')
                    stand[i] = c - 'A';
            }
            
            for (; i < tmp.length(); i++) {

            }
        }
    }
}
