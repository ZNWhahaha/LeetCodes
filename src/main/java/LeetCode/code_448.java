package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。


public class code_448 {

    // 使用额外空间
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> tmp = new HashMap<>();
        for (int i : nums){
            tmp.put(i,1);
        }
        for (int i = 1; i <= n; i++) {
            if (tmp.containsKey(i) == false)
                result.add(i);
        }
        return result;
    }

    // 数组原地修改
    public List<Integer> findDisappearedNumbers_1(int[] nums){
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i : nums){
            int x = (i - 1) % n;
            nums[x] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n)
                result.add(i+1);
        }
        return result;
    }
}
