package hj;

import com.sun.tools.javac.code.Attribute;

import java.util.Arrays;
import java.util.Scanner;

public class hj_45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            String n = in.nextLine();
            for (int i = 0; i < Integer.valueOf(n); i++) {
                char[] name = in.nextLine().toCharArray();
                int result = 0;
                int tmp = 26;
                int[] check = new int[26];
                for (int j = name.length-1; j >= 0 ; j--) {
                    if (name[j] >= 'a' && name[j] <= 'z')
                        check[name[j]- 'a'] += 1;
                    else if (name[j] >= 'A' && name[j] <= 'Z')
                        check[name[j]- 'A'] += 1;
                }
                Arrays.sort(check);
                for (int j = check.length-1 ; j >= 0 && check[j] != 0; j--) {
                    result += check[j] * tmp;
                    tmp --;
                }
                System.out.println(result);
            }
        }
    }
}
