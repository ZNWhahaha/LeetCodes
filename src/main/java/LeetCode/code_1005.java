package LeetCode;

import java.util.Arrays;

public class code_1005 {

//    给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
//    以这种方式修改数组后，返回数组可能的最大和。
//    示例 1：
//    输入：A = [4,2,3], K = 1
//    输出：5
//    解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && K > 0){
                A[i] = -A[i];
                K --;
            }
        }
        Arrays.sort(A);
        while (K-- == 0){
            A[0] *= -1;
        }
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }
}
