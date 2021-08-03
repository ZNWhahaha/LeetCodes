package hj;

import java.util.Map;
import java.util.Scanner;

public class hj_52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            int m = a.length();
            int n = b.length();
            int[][] dp = new int[m+1][n+1];

            for (int i = 1; i <= m ; i++) {
                dp[i][0] = i;
            }

            for (int i = 1; i <= n; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i <= m ; i++) {
                for (int j = 1; j <= n ; j++) {
                    if (a.charAt(i-1) == b.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) + 1;
                }
            }
            System.out.println(dp[m][n]);
        }
    }
}
