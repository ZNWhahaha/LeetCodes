package LeetCode;

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

import java.util.HashMap;

public class code_560 {
    // 前缀和
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] presum = new int[len+1];
        for (int i = 0; i < len; i++) {
            presum[i+1] = presum[i] + nums[i];
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (presum[j+1] - presum[i] == k)
                    result ++;
            }
        }
        return result;
    }

    // 前缀和+哈希表优化
    public int subarraySum_1(int[] nums, int k){
        int count = 0;
        int pre = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int n : nums){
            pre += n;
            if (map.containsKey(pre - k))
                count += map.get(pre - k);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
