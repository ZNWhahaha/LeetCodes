package LeetCode;

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_338 {

    public int[] countBits(int n) {
        int[]  bits = new int[n+1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
