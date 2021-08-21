package test;

public class youzan_02 {
    public int maxSubArray (int[] nums) {
        // write code here
        if (nums.length == 0)
            return 0;

        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
//            if (result > dp[i])
//                result = result;
//            else
//                result = dp[i];
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
