package LeetCode;

public class code_322 {
//    给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
//    你可以认为每种硬币的数量是无限的。
    
//    示例 1：
//
//    输入：coins = [1, 2, 5], amount = 11
//    输出：3
//    解释：11 = 5 + 5 + 1
//    示例 2：
//
//    输入：coins = [2], amount = 3
//    输出：-1


//    确定dp数组以及下标的含义
//    dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
//
//    确定递推公式
//    得到dp[j]（考虑coins[i]），只有一个来源，dp[j - coins[i]]（没有考虑coins[i]）。
//
//    凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，那么只需要加上一个钱币coins[i]即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
//
//    所以dp[j] 要取所有 dp[j - coins[i]] + 1 中最小的。
//
//    递推公式：dp[j] =  min(dp[j - coins[i]] + 1, dp[j]);
//
//    dp数组如何初始化
//    首先凑足总金额为0所需钱币的个数一定是0，那么dp[0] = 0;
//
//    其他下标对应的数值呢？
//
//    考虑到递推公式的特性，dp[j]必须初始化为一个最大的数，否则就会在min(dp[j - coins[i]] + 1, dp[j])比较的过程中被初始值覆盖。
//
//    所以下标非0的元素都是应该是最大值。

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                // 如果dp[j - coins[i]]是初始值则跳过
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
