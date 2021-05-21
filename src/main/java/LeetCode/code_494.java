package LeetCode;

public class code_494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (S > sum)
            return 0;
        if ((S + sum) % 2 == 1)
            return 0;
        int bigsize = (S + sum) / 2;
        int[] dp = new int[bigsize+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bigsize; j >= nums[i] ; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bigsize];
    }
}
