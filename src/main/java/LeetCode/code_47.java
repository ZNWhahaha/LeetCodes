package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_47 {

//    给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//    示例 1：
//    输入：nums = [1,1,2]
//    输出：
//            [[1,1,2],
//            [1,2,1],
//            [2,1,1]]

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public void backtracking(int[] nums,boolean[] used){
        if (path.size() == nums.length && !result.contains(new ArrayList<>(path))){
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false)
                continue;
            if (used[i] == false){
                used[i] = true;
                path.addLast(nums[i]);
                backtracking(nums,used);
                path.removeLast();
                used[i] = false;
            }

        }

    }
}
