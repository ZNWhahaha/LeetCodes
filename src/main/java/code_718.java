public class code_718 {

//    给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度

    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i] == nums2[j])
                    dp[i][j] = dp[i-1][j-1]+1;
                if (dp[i][j] > result)
                    result = dp[i][j];
            }
        }

        return result;
    }
}
