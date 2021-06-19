package LeetCode;

//给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//        一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//        找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)

public class code_695 {

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int tmp = area(grid,i,j);
                result = Math.max(tmp,result);
            }
        }
        return result;
    }

    private int area(int[][] grid, int r, int c){
        if (!inArea(grid,r,c))
            return 0;
        if (grid[r][c] != 1)
            return 0;
        grid[r][c] = 2;

        return 1
                + area(grid,r,c-1)
                + area(grid,r,c+1)
                + area(grid,r-1,c)
                + area(grid,r+1,c);
    }

    private boolean inArea(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
