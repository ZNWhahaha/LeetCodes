package LeetCode;

//根据 逆波兰表示法，求表达式的值。
//        有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

import java.util.Stack;

public class code_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens.equals('+')){
                n2 = st.pop();
                n1 = st.peek();
                st.push(n1+n2);
            }
            else if (tokens.equals('-')){
                n2 = st.pop();
                n1 = st.peek();
                st.push(n1-n2);
            }
            else if (tokens.equals('*')){
                n2 = st.pop();
                n1 = st.peek();
                st.push(n1*n2);
            }
            else if (tokens.equals('/')){
                n2 = st.pop();
                n1 = st.peek();
                st.push(n1/n2);
            }
            else
                st.push(Integer.valueOf(tokens[i]));
        }
        return st.pop();
    }
}
