package helpOthers;

import java.util.LinkedList;
import java.util.Queue;

public class Sunmy_wangyi_04 {
    public static int minSailCost_dp(int[][] input){
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == 2)
                    input[i][j] = 99999;
                else
                    input[i][j] += 1;
            }
        }

        dp[0][0] = input[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + input[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + input[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + input[i][j];
            }
        }

        return dp[m-1][n-1] - dp[0][0];
    }

    public static int minSailCost(int[][] input){
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int rows = input.length;
        int cols = input[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (input[i][j] == 2)
                    input[i][j] = 99999;
                else
                    input[i][j] += 1;
            }
        }

        int result = 0;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for(int[] dir:directions){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>=0 && nx<rows && ny>=0 && ny<cols && !visited[nx][ny]){
                    queue.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int[][] input = {{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};
        System.out.println(minSailCost(input));
    }
}
