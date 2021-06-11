package LeetCode;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class code_128 {
    //使用排序
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 0)
            return 0;
        Arrays.sort(nums);
        int maxLen = 0;
        int cur = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]+1 == nums[i+1])
                cur += 1;
            else if(nums[i] == nums[i+1])
                continue;
            else
                cur = 0;
            maxLen = Math.max(maxLen,cur);
        }
        return maxLen+1;
    }

    //哈希表
    public int longestConsecutive_1(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
