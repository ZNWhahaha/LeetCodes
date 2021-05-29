package LeetCode;

//给你一个字符串 s，找到 s 中最长的回文子串。

public class code_05 {


    //中心扩散法
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    //动态规划

    public String longestPalindrome_1(String s){
        if (s== null || s.length() < 2)
            return s;

        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 0;
        int sLen = s.length();

        boolean[][] dp = new boolean[sLen][sLen];

        for (int i = 1; i < sLen; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1][i-1]))
                    dp[j][i] = true;
                if (i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    maxStart = j;
                    maxEnd = i;
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }

}
