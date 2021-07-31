package test;

public class onepot_02 {
    public int findMin (int[][] mapArray) {
        int x = mapArray.length;
        int y = mapArray[0].length;
        int[][] dp = new int[x][y];
        dp[0][0] = mapArray[0][0];
        for (int i = 1; i < x; i++) {
            dp[0][i] = dp[0][i-1] + mapArray[0][i];
            dp[i][0] = dp[i-1][0] + mapArray[i][0];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + mapArray[i][j];
            }
        }
        return dp[x][y];
    }
}
