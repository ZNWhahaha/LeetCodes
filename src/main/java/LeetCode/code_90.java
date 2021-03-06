package LeetCode;

import java.util.*;

public class code_90 {

//    给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//    解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//    示例 1：
//    输入：nums = [1,2,2]
//    输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//    示例 2：
//    输入：nums = [0]
//    输出：[[],[0]]


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        backtracking(nums,0,used);
        return result;
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<Integer> path = new ArrayDeque<>();

    public void backtracking(int[] nums,int startIndex,boolean[] used){
        result.add(new ArrayList<Integer>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false)
                continue;
            path.addLast(nums[i]);
            used[i] = true;
            backtracking(nums,i+1,used);
            used[i] = false;
            path.removeLast();
        }
    }
}
