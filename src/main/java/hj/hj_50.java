package hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class hj_50 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            change(str);
        }
    }

    // 中缀转后缀
    public static void change(String str) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String cStr = String.valueOf(c);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(cStr);
            } else if (c == ')' || c == ']' || c == '}') {
                while ((!stack.isEmpty()) && (!("(".equals(stack.peek()) ||
                        "[".equals(stack.peek()) ||
                        "{".equals(stack.peek())))) {
                    list.add(stack.pop());
                }
                stack.pop();
            } else if (isNum(c)) {
                int a = 1;
                while ((i + a) < str.length() && isNum(str.charAt(i + a))) {
                    a++;
                }
                list.add(str.substring(i, i + a));
                i = i + a - 1;
            } else if (c == '-') {
                // 判断负号
                if (i == 0 || str.charAt(i - 1) == '(' || str.charAt(i - 1) == '['
                        || str.charAt(i - 1) == '{') {
                    int a = 1;
                    while ((i + a) < str.length() && isNum(str.charAt(i + a))) {
                        a++;
                    }
                    list.add(str.substring(i, i + a));
                    i = i + a - 1;
                } else {
                    // 减号
                    while (!stack.isEmpty() && grate(c, stack.peek())) {
                        list.add(stack.pop());
                    }
                    stack.push(cStr);
                }
            } else if (c == '+' || c == '*' || c == '/') {
                // 减号
                while (!stack.isEmpty() && grate(c, stack.peek())) {
                    list.add(stack.pop());
                }
                stack.push(cStr);
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        cal(list);
    }

    public static void cal(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (!(s.equals("+") ||
                    s.equals("-") ||
                    s.equals("*") ||
                    s.equals("/"))) {
                stack.push(Integer.valueOf(s));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                if (s.equals("+")) {
                    stack.push(a + b);
                }
                if (s.equals("-")) {
                    stack.push(a - b);
                }
                if (s.equals("*")) {
                    stack.push(a * b);
                }
                if (s.equals("/")) {
                    stack.push(a / b);
                }
            }
        }
        System.out.println(stack.pop());
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean grate(char a, String b) {
        if (b.equals("(") || b.equals("[") || b.equals("{")) {
            return false;
        }
        if (a == '*' || a == '/') {
            return b.equals("*") || b.equals("/");
        }
        if (a == '+' || a == '-') {
            return b.equals("+") || b.equals("-") || b.equals("*") || b.equals("/");
        }
        return false;
    }
}
