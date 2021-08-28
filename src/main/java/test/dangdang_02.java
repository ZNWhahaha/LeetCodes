package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class dangdang_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        StringBuilder sb_str = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c == '<' || c == '>')
                continue;
            if (c == '/'){
                i++;
                sb_str.append(tmp.charAt(i) -'a'+'A');
                continue;
            }
            sb_str.append(c);
        }
        String str = sb_str.toString();
        if (isValid(str)){
            System.out.println("invalid xml");
            return;
        }
        System.out.println(Deep(str));
    }

    private static boolean isValid(String str){
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                deque.push((char) (ch-'a'+'A'));
            else if (deque.isEmpty())
                deque.pop();
        }
        return deque.isEmpty();
    }

    private static int Deep(String str){
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                cnt ++;
            else
                cnt --;
            max = Math.max(max,cnt);
        }
        return max;
    }
}
