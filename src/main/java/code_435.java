import java.util.Arrays;
import java.util.Comparator;

public class code_435 {

//    给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//    注意:
//    可以认为区间的终点总是大于它的起点。
//    区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//    示例 1:
//    输入: [ [1,2], [2,3], [3,4], [1,3] ]
//    输出: 1
//    解释: 移除 [1,3] 后，剩下的区间没有重叠。
//    示例 2:
//    输入: [ [1,2], [1,2], [1,2] ]
//    输出: 2
//    解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0])
                    return 1;
                else
                    return -1;
            }
        });

        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]){
                result += 1;
                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
            }
        }
        return result;
    }
}
