package helpOthers;

import java.util.Scanner;
import java.util.Stack;

public class Yaoyi_dahua_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        System.out.println(isValid(tmp) ? "true" : "false");
    }
    public static boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }

        return stack.isEmpty();
    }
}
