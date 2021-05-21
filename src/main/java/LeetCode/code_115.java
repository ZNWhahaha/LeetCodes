package LeetCode;

import java.util.Arrays;

public class code_115 {

//    给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//
//    字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//
//    题目数据保证答案符合 32 位带符号整数范围。

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[s.length()][t.length()];
    }

    public int numDistinct_1(String s, String t) {
        int t_len = t.length();
        int[] dp = new int[t_len+1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = t_len; j > 0; j--) {
                if (s.charAt(i) == t.charAt(j-1))
                    dp[j] += dp[j-1];
            }
        }
        return dp[t_len];
    }
}
