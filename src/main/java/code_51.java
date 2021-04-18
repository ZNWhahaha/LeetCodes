import java.util.*;

public class code_51 {

//    n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//    给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//    每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//    输入：n = 4
//    输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//    解释：如上图所示，4 皇后问题存在两个不同的解法。
//    示例 2：
//    输入：n = 1
//    输出：[["Q"]]


    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] line : chessboard)
            Arrays.fill(line,'.');
        backtracking(n,0,chessboard);
        return result;
    }

    List<List<String>> result = new ArrayList<>();

    public void backtracking(int n,int row,char[][] chessboard){
        if (n == row){
            List<String> copyBoard = new ArrayList<>();
            for (char[] line : chessboard) {
                copyBoard.add(String.valueOf(line));
            }
            result.add(copyBoard);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(n,row,col,chessboard)){
                chessboard[row][col] = 'Q';
                backtracking(n,row+1,chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public boolean isValid(int n,int row,int col,char[][] chessboard){
        for (int i = 0; i < n; i++) {
            if (chessboard[i][col] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        return true;

    }
}
