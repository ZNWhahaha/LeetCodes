package hj;

//输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
//        本题包含多组输入。


import java.util.Scanner;

public class hj_40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNext()) { // 注意 while 处理多个 case
                String tmp = in.nextLine();
                int eng = 0;
                int space = 0;
                int num = 0;
                int other = 0;
                for (int i = 0; i < tmp.length(); i++) {
                    char c = tmp.charAt(i);
                    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                        eng += 1;
                    else if (c == ' ')
                        space += 1;
                    else if (c >= '0' && c <= '9')
                        num += 1;
                    else
                        other += 1;
                }
                System.out.println(eng);
                System.out.println(space);
                System.out.println(num);
                System.out.println(other);
        }
    }
}
