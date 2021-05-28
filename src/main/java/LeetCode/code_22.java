package LeetCode;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

import java.util.LinkedList;
import java.util.List;

public class code_22 {

    List<String> result = new LinkedList<>();
    public List<String> generateParenthesis_1(int n) {
        if(n <= 0){
            return result;
        }
        getParenthesis("",n,n);
        return result;
    }

    private void getParenthesis(String str,int left,int right){
        if (left == 0 && right == 0){
            result.add(str);
            return;
        }
        if (left == right){
            getParenthesis(str+'(',left-1,right);
        }
        else if (left < right){
            if (left > 0)
                getParenthesis(str+'(',left-1,right);
            getParenthesis(str+')',left,right-1);
        }
    }

    //回溯法
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(result,new StringBuilder(),0,0,n);
        return result;
    }

    private void backtrack(List result,StringBuilder sb,int open,int close,int max){
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }
        if (open < max){
            sb.append('(');
            backtrack(result,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close < open){
            sb.append(')');
            backtrack(result,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
