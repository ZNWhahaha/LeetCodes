public class code_37 {
//    编写一个程序，通过填充空格来解决数独问题。
//    数独的解法需 遵循如下规则：
//    数字 1-9 在每一行只能出现一次。
//    数字 1-9 在每一列只能出现一次。
//    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//    数独部分空格内已填入了数字，空白格用 '.' 表示。
//    输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
//    输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]


    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isVald(i,j,k,board)){
                        board[i][j] = k;
                        if (backtracking(board))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isVald(int row,int col,char val,char[][] board){
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val)
                return false;
        }
        int startrow = (row / 3) * 3;
        int startcol = (col / 3) * 3;

        for (int i = startrow; i < startrow+3; i++) {
            for (int j = startcol; j < startcol+3; j++) {
                if (board[i][j] == val)
                    return false;
            }
        }
        return true;
    }
}
