package LeetCode;

public class code_474 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int oneNum = 0,
                    zoreNum = 0;
            char[] chars = new char[100];
            chars = str.toCharArray();
            for (char c : chars){
                if(c == '0'){
                    zoreNum += 1;
                }
                else{
                    oneNum += 1;
                }
            }
            for (int i = m; i >= zoreNum; i--) {
                for (int j = n; j >= oneNum ; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-zoreNum][j-oneNum] + 1);
                }
            }

        }
        return dp[m][n];

    }
}
