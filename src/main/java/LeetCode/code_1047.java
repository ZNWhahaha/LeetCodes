package LeetCode;

//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//        在 S 上反复执行重复项删除操作，直到无法继续删除。
//        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class code_1047 {

    public String removeDuplicates(String s) {
        if (s.length() <= 1)
            return s;
        Deque<Character> queue = new LinkedList<>();
        queue.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!queue.isEmpty() && queue.getLast() == s.charAt(i)){
                queue.removeLast();
                continue;
            }
            queue.addLast(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.getFirst());
            queue.removeFirst();
        }
        return sb.toString();
    }
    //用字符串直接作为栈
    public String removeDuplicates_1(String s) {
        // 将 res 当做栈
        StringBuffer res = new StringBuffer();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }

}
