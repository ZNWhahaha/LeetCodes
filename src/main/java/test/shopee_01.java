package test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class shopee_01 {
//    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
//        // write code here
//        int a = rooms.length;
//        int b = rooms[0].length;
//        int[][] room_life = new int[a+2][b+2];
//        for (int i = 0; i < a+2; i++) {
//            room_life[i][0] = 1;
//            room_life[i][a+1] = 1;
//        }
//        for (int i = 0; i < b+2; i++) {
//            room_life[0][i] = 1;
//            room_life[b+1][i] = 1;
//        }
//
//        int[][] dp = new int[a+2][b+2];
//        dp[1][1] = rooms[0][0];
//
//        for (int i = a+1; i >= 0; i++) {
//            for (int j = b+1; j >= 0; j++) {
//                room_life[i][j] = 1;
//                int up = Integer.MIN_VALUE;
//                int down = Integer.MIN_VALUE;
//                int left = Integer.MIN_VALUE;
//                int right = Integer.MIN_VALUE;
//                if (room_life[i+1][j] != 1)
//                    up = room_life[i+1][j];
//                if (room_life[i-1][j] != 1)
//                    down = room_life[i-1][j];
//                if (room_life[i][j-1] != 1)
//                    left = room_life[i][j-1];
//                if (room_life[i][j+1] != 1)
//                    right = room_life[i][j+1];
//                dp[i][j] =
//            }
//        }
//    }

    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        // write code here
        int[][] used = new int[rooms.length][rooms[0].length];
        int sum = rooms[startPoint[0]][startPoint[1]];
        glo_x = endPoint[0];
        glo_y = endPoint[1];
        result = sum;
        dfs(rooms,used,startPoint[0],startPoint[1],sum);
        int re = 0;
        for (Iterator<Integer> it = tmp.iterator(); it.hasNext(); ) {
            Integer i = it.next();
            re += i;
            if (re > 0)
                re = re - i;
            break;
        }
        return -re;
    }

    int result = Integer.MIN_VALUE;
    int glo_x = 0;
    int glo_y = 0;
    int[] loc_x = {1,0,-1,0};
    int[] loc_y = {0,-1,0,1};
    Deque<Integer> tmp = new ArrayDeque<>();

    private void dfs(int[][] rooms, int[][] used, int x,int y,int sum){
        if (x == glo_x && y == glo_y){
            result = Math.max(result,sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int new_x = x + loc_x[i];
            int new_y = y + loc_y[i];
            if(new_x >= 0 && new_x <rooms.length && new_y >= 0 && new_y < rooms[0].length &&
                    used[new_x][new_y] == 0){
                used[new_x][new_y] = 1;
                sum += rooms[new_x][new_y];
                tmp.addLast(rooms[new_x][new_y]);
                dfs(rooms,used,new_x,new_y,sum);
                tmp.removeLast();
                sum -= rooms[new_x][new_y];
                used[new_x][new_y] = 0;
            }
        }
    }
}
