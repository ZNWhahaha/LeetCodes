package LeetCode;

import java.util.Arrays;

public class code_floyd {

    private int[][]  floyd(int[][] map){
        for (int k = 0; k < map.length; k++) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (map[i][j] > map[i][k]+map[k][j])
                        map[i][j] = map[i][k]+map[k][j];
                }
            }    
        }
        return map;
    }
    
}
