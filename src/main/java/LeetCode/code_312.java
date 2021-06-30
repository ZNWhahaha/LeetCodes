package LeetCode;

//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//        现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
//        求所能获得硬币的最大数量。

public class code_312 {
    // 动态规划五部曲
    // 1. dp数组及下表含义
    //      dp[i][j] 表示从数组i，到数组j（不包含i，j），戳破气球所能获得的最大金额
    // 2. 递推公式
    //      dp[i][j] = max(dp[i][j],dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j])
    // 3. dp数组初始化
    //      dp数组全为0
    // 4. 遍历方向
    //      从左到右
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n+2];
        int[][] dp = new int[n+2][n+2];
        val[0] = 1;
        val[n+1] = 1;
        for (int i = 1; i < n+1; i++) {
            val[i] = nums[i-1];
        }

        for (int len = 3; len <= n+2; len++) {
            for (int i = 0; i <= n+2-len; i++) {
                int res = 0;
                for (int k = i+1; k < i+len-1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i+len-1];
                    res = Math.max(res, left + right + val[i] * val[k] * val[i+len-1]);
                }
                dp[i][i+len-1] = res;
            }    
        }
        return dp[0][n+1];
    }
}
