package LeetCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_46 {

//    给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//    示例:
//    输入: [1,2,3]
//    输出:
//            [
//            [1,2,3],
//            [1,3,2],
//            [2,1,3],
//            [2,3,1],
//            [3,1,2],
//            [3,2,1]
//            ]

    public List<List<Integer>> permute(int[] nums) {
        backstracking(nums);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public void backstracking(int[] nums){
        if (path.size() == nums.length)
            result.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i]))
                continue;
            path.addLast(nums[i]);
            backstracking(nums);
            path.removeLast();
        }
    }
}
