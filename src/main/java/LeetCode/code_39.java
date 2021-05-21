package LeetCode;

import java.util.*;

public class code_39 {

//    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//    candidates 中的数字可以无限制重复被选取。
//    说明：
//    所有数字（包括 target）都是正整数。
//    解集不能包含重复的组合。 
//    示例 1：
//    输入：candidates = [2,3,6,7], target = 7,
//    所求解集为：
//            [
//            [7],
//            [2,2,3]
//            ]
//    示例 2：
//    输入：candidates = [2,3,5], target = 8,
//    所求解集为：
//            [
//              [2,2,2,2],
//              [2,3,3],
//              [3,5]
//            ]

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,0,target,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<Integer> path = new ArrayDeque<Integer>();

    public void backtracking(int[] candidates,int sum,int target,int startIndex){
        if (sum > target)
            return;

        if (sum == target){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.addLast(candidates[i]);
            backtracking(candidates,sum,target,i);
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
