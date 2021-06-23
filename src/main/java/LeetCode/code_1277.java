package LeetCode;

//给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。

public class code_1277 {
    public int countSquares(int[][] matrix) {
        int result = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                result += 1;
            }

        }
        for (int i = 0; i < columns; i++) {
            if (matrix[0][i] == 1){
                dp[0][i] = 1;
                result += 1;
            }

        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    result += dp[i][j];
                }

            }
        }
        return result;
    }
}
