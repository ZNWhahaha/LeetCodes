package LeetCode;

//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
//        返回所有可能的结果。答案可以按 任意顺序 返回。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code_301 {

    int len;

    public List<String> removeInvalidParentheses(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 0;

        for (char c : cs) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                r++;
            }
        }

        int max = Math.min(l, r);
        Set<String> all = new HashSet<>();
        dfs(cs, 0, 0, max, "", all);
        List<String> ans = new ArrayList<>();
        for (String str : all) {
            if (str.length() == len) ans.add(str);
        }
        return ans;
    }

    private void dfs(char[] cs, int index, int sorce, int max, String cur, Set<String> ans){
        if (index == cs.length){
            if (sorce == 0 && cur.length() >= len){
                len = Math.max(len, cur.length());
                ans.add(cur);
            }
            return;
        }

        if (cs[index] == '('){
            if (sorce+1 <= max)
                dfs(cs, index+1, sorce+1, max, cur+'(', ans);
            dfs(cs, index + 1, sorce, max, cur, ans);
        }
        else if (cs[index] == ')'){
            if (sorce > 0)
                dfs(cs, index+1, sorce-1, max, cur+')', ans);
            dfs(cs, index+1, sorce, max, cur, ans);
        }
        else
            dfs(cs, index+1, sorce, max, cur+String.valueOf(cs[index]), ans);
    }
}
