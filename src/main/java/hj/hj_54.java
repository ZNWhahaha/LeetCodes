package hj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class hj_54 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        System.out.println(new ExprDemo().expr(in));
    }
    public static class ExprDemo{

        public char lastsign1 = 0, lastsign2 = 0;
        public int temp1 = 0, temp2 = 0;
        private static final char TEMPCHAR = 0;

        public int expr(InputStream in) throws IOException {
            int result = 0;
            char c;
            //循环遍历读取计算式中的所有字符
            a: while((c = (char)in.read()) != '\n') {
                switch (c) {
                    case ')':
                    case ']':
                        //当遇到"}"时中断switch
                    case '}': break a;
                    case '(':
                    case '[':
                        //当遇到"{"是
                    case '{': temp2 = new ExprDemo().expr(in); break;
                    case '+':
                    case '-':
                        jisuan1(TEMPCHAR);
                        result = jisuan2(c, result);
                        break;
                    case '*':
                    case '/':
                        jisuan1(c);
                        break;
                    default: temp2 = temp2 * 10 + c - '0'; break;
                }
            }
            jisuan1(TEMPCHAR);
            result = jisuan2(TEMPCHAR, result);
            return result;
        }

        private void jisuan1(char c) {
            switch (lastsign2) {
                case 0: temp1 = temp2; break;
                case '*': temp1 *= temp2; break;
                case '/': temp1 /= temp2; break;
                default: break;
            }
            temp2 = 0;
            lastsign2 = c;
        }

        private int jisuan2(char c, int result) {
            switch (lastsign1) {
                case 0: result = temp1; break;
                case '-': result -= temp1; break;
                case '+': result += temp1; break;
                default: break;
            }
            temp1 = 0;
            lastsign1 = c;
            return result;
        }
    }
}
