package LeetCode;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//        此外，你可以假设该网格的四条边均被水包围。

public class code_200 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    area(grid,i,j);
                    result += 1;
                }
            }
        }
        return result;
    }

    private void area(char[][] grid, int r, int c){
        if (!inArea(grid,r,c))
            return;
        if (grid[r][c] != '1')
            return;
        grid[r][c] = '2';
        area(grid,r-1,c);
        area(grid,r+1,c);
        area(grid,r,c+1);
        area(grid,r,c-1);
    }

    private boolean inArea(char[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
