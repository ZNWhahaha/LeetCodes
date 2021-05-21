package LeetCode;

public class code_1049 {
    public int lastStoneWeightII(int[] stones) {
        int[] dp = new int[15001];
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]] + stones[i]);
            }
        }
        return sum - dp[target]*2;
    }
}
