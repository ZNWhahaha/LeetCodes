package LeetCode;

public class code_53 {
//    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//    示例 1：
//    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//    输出：6
//    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//    示例 2：
//    输入：nums = [1]
//    输出：1

    //贪心算法
    public int maxSubArray_1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value += nums[i];
            if (value >= result)
                result = value;
            if (value < 0)
                value = 0;
        }
        return result;
    }

    //动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            if(dp[i] > result)
                result = dp[i];
        }
        return result;
    }
}
