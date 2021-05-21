package LeetCode;

import java.util.*;

public class code_491 {

//    给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
//    示例：
//    输入：[4, 6, 7, 7]
//    输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<Integer> path = new ArrayDeque<>();
    
    public void backtracking(int[] nums,int startIndex){
        if (path.size() > 1)
            result.add(new ArrayList<Integer>(path));
        List<Integer> used = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast() || used.indexOf(nums[i]) >= 0)
                continue;
            path.addLast(nums[i]);
            used.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
