package LeetCode;

public class code_213 {

//    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = 0;
        dp1[1] = nums[1];
        for (int i = 2; i < dp1.length; i++) {
            dp1[i]  = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }
        dp2[0] = nums[0];
        dp2[1] = Math.max(dp2[0],nums[1]);
        for (int i = 2; i < dp2.length-1; i++) {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[dp1.length],dp2[dp2.length]);
    }
}
