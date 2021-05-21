package LeetCode;

public class code_647 {

//    给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//    具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

    public int countSubstrings(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1)
            return 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2,
                    right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
    
}
