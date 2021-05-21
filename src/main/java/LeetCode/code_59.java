package LeetCode;

public class code_59 {

//    给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start_x = 0,start_y = 0;
        int loop = n / 2;
        int mid = n / 2;
        int count = 1;
        int offset = 1;
        int i,j;
        while (loop-- != 0){
            i = start_x;
            j = start_y;
            for (j = start_y; j < start_y + n - offset; j++) {
                result[start_x][j] = count++;
            }
            for (i = start_x; i < start_x + n - offset; i++) {
                result[i][j] = count++;
            }
            for (;j > start_y ; j--) {
                result[i][j] = count++;
            }
            for (;i > start_x ; i--){
                result[i][j] = count++;
            }
            start_x++;
            start_y++;
            offset += 2;
        }
        if (n % 2 == 1){
            result[mid][mid] = count++;
        }
        return result;
    }
}
