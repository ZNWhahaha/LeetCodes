package hj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class hj_09 {
    public static void main_1(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()){
            int a = in.nextInt();
            Stack stack = new Stack();
            String[] number = String.valueOf(a).split("");
            for (int i = 0; i < number.length; i++) {
                 stack.push(number[i]);
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.empty()){
                if (sb.indexOf(String.valueOf(stack.peek())) < 0){
                    sb.append(stack.pop());
                }
                else
                    stack.pop();
            }
            System.out.println(sb.toString());
        }
    }
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        int length = in.available()-1;
        char[] charlist = new char[length];
        for (int i = 0; i < charlist.length; i++) {
            charlist[i] = (char) in.read();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = charlist.length-1; i >= 0 ; i--) {
            if (sb.indexOf(String.valueOf(charlist[i])) == -1){
                sb.append(charlist[i]);
            }
        }
        System.out.println(sb.toString());
        
    }
}
