package SwordFingerOffer;

public class offer_13 {
    
    int [][] presum;

    public offer_13(int[][] matrix) {
        int Row = matrix.length;
        int Col = matrix[0].length;
        this.presum = new int [Row + 1][Col + 1];
        for (int r = 0; r < Row; r ++)
            for (int c = 0; c < Col; c ++)
                presum[r+1][c+1] = presum[r+1][c] + presum[r][c+1] - presum[r][c] + matrix[r][c];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = presum[row2 + 1][col2 + 1] - presum[row2 + 1][col1] - presum[row1][col2 + 1] + presum[row1][col1];
        return res;
    }
}
