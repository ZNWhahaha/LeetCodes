public class code_188 {

//    给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1)
            return 0;
        int[][] dp = new int[len][2*k+1];

        for (int j = 1; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                dp[i][j+1] = Math.max(dp[i-1][j+1],dp[i-1][j]-prices[i]);
                dp[i][j+2] = Math.max(dp[i-1][j+2],dp[i-1][j+1]+prices[i]);
            }
        }

        return dp[len-1][2*k];
    }
}
