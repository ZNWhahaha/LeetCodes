package LeetCode;

public class code_416 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[] dp = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
                System.out.println("j="+j+" i="+i+" dp[j]="+dp[j] + " nums[i]=" + nums[i] + " dp[j - nums[i]]=" +dp[j - nums[i]]);
            }
        }
        if (dp[target] == target) return true;
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,5,11,5};
        canPartition(nums);
    }
}
