package helpOthers;

import java.util.Arrays;

public class Wangcd_bilibili_02 {
    public static int[] GetSortedTasks(int[][] taskLists){
        int[] lens = new int[taskLists.length];
        int len = 0;
        for (int i = 0; i < lens.length; i++) {
            lens[i] = taskLists[i].length-1;
            len += taskLists[i].length;
        }
        len --;
        int[] result = new int[len+1];
        while(len >= 0) {
            int max = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < lens.length; i++) {
                if (lens[i] >= 0 && taskLists[i][lens[i]] > max){
                    max = taskLists[i][lens[i]];
                    index = i;
                }
            }
            result[len--] = max;
            lens[index]--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3,4},{1,2,3,7}};
        int[] re = GetSortedTasks(a);
        for (int i : re)
            System.out.println(i);
    }
}
