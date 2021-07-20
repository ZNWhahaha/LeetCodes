package hj;

import java.util.*;

public class hj_43 {

    public static int[][] directions = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    private static Stack<int[]> path;
    private static ArrayList<int[]> minPath;
    private static int[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            path = new Stack<>();
            minPath = null;
            matrix = new int[a][b];
            visited = new boolean[a][b];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            dfs(0, 0);

            StringBuilder sb = new StringBuilder();
            for (int[] res : minPath) {
                sb.append('(').append(res[0]).append(',').append(res[1]).append(")\n");
            }
            System.out.print(sb.toString());
            
        }
    }

    private static void dfs(int i, int j) {
        if (i > matrix.length - 1 || i < 0 || j > matrix[0].length - 1 || j < 0 ||
                visited[i][j] || matrix[i][j] == 1 ||
                (minPath != null && path.size() >= minPath.size())) {
            return;
        }
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            path.add(new int[]{i, j});
            minPath = new ArrayList<>(path);
            path.pop();
            return;
        }
        path.add(new int[]{i, j});
        visited[i][j] = true;
        for (int[] direction : directions) {
            dfs(i + direction[0], j + direction[1]);
        }
        visited[i][j] = false;
        path.pop();
    }
}
