package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class code_56 {

//    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//    示例 1：
//    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//    输出：[[1,6],[8,10],[15,18]]
//    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//    示例 2：
//    输入：intervals = [[1,4],[4,5]]
//    输出：[[1,5]]
//    解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> re = new LinkedList<int[]>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i-1][1]){
                intervals[i][0] = Math.min(intervals[i][0],intervals[i-1][0]);
                intervals[i][1] = Math.max(intervals[i][1],intervals[i-1][1]);
            }
            else {
                re.add(intervals[i-1]);
            }
        }
        re.add(intervals[intervals.length-1]);
        int[][] result = new int[re.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = re.get(i);
        }

        return result;
    }

    public static void main(String[] args){
//        [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
        int[][] p = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        merge(p);
    }
}
