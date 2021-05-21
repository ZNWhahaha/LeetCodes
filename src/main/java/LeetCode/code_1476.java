package LeetCode;

public class code_1476 {
    private int[][] rec = null;
    public code_1476(int[][] rectangle) {
        this.rec = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if(rec != null){
            for(int i = row1; i <= row2; ++ i){
                for(int j = col1; j <= col2; ++ j){
                    rec[i][j] = newValue;
                }
            }
        }
    }

    public int getValue(int row, int col) {
        if(rec != null){
            return rec[row][col];
        }
        return -1;
    }
}
