package LeetCode;

//给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
//        网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//        岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。


public class code_463 {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return area(grid,i,j);
            }
        }
        return 0;
    }

    private int area(int[][] grid, int r, int c){
        if (!inArea(grid,r,c))
            return 1;
        if (grid[r][c] == 0)
            return 1;
        if (grid[r][c] != 1)
            return 0;
        grid[r][c] = 2;

        return area(grid,r-1,c)
                + area(grid,r+1,c)
                + area(grid,r,c-1)
                + area(grid,r,c+1);

    }

    private boolean inArea(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
