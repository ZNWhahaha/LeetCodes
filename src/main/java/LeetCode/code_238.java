package LeetCode;

// 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

import java.util.Arrays;

public class code_238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result,1);
        int p = 1;
        int q = 1;
        for (int i = 0; i < len; i++) {
            result[i] *= p;
            p *= nums[i];
            result[len-i-1] *= q;
            q *= nums[len-i-1];
        }
        return result;
    }
}
