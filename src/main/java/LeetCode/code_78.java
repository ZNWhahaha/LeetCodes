package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_78 {

//    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//    示例 1：
//    输入：nums = [1,2,3]
//    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//    示例 2：
//    输入：nums = [0]
//    输出：[[],[0]]

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<Integer> path = new ArrayDeque<>();

    public void backtracking(int[] nums,int startIndex){
        result.add(new ArrayList<Integer>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
