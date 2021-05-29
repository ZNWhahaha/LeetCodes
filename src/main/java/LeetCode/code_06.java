package LeetCode;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//        '.' 匹配任意单个字符
//        '*' 匹配零个或多个前面的那一个元素
//        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

public class code_06 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

//        初始化这里初始化 "" 和p的匹配关系。为什么每次都加2，是因为不管p的奇数位是什么字符，都不可能匹配空串。
//        匹配空串的p必然是这样子的a*a*a*a*a*a*a* 。 所以只看偶数位就好了，只要偶数位为*，就可以把当前的*和前
//    一个字符删除掉,看前面两个字符的结果即可， dp[0][i] = dp[0][i - 2]。另外，字符串类动态规划中，空串的初始
//    化很重要，这是base case
        for (int i = 2; i <= n; i+= 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1) ;
                if (sc == pc || pc == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if (pc == '*'){
                    if (dp[i][j-2])
                        dp[i][j] = true;
                    else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

}
