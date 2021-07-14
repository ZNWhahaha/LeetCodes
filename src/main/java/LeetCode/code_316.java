package LeetCode;

//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

import java.util.Deque;
import java.util.LinkedList;

public class code_316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c % 97]++;
        }
        boolean[] inStackArray = new boolean[26];
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()){
            count[c % 97]--;
            if (inStackArray[c % 97])
                continue;
            while (!stack.isEmpty() && stack.peek() > c){
                if (count[stack.peek() % 97] == 0)
                    break;
                inStackArray[stack.pop() % 97] = false;
            }

            stack.push(c);
            inStackArray[c % 97] = true;
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
