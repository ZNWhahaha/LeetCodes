import java.util.*;

public class code_40 {

//    给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//    candidates 中的每个数字在每个组合中只能使用一次。
//    说明：
//    所有数字（包括目标数）都是正整数。
//    解集不能包含重复的组合。 
//    示例 1:
//    输入: candidates = [10,1,2,7,6,1,5], target = 8,
//    所求解集为:
//            [
//            [1, 7],
//            [1, 2, 5],
//            [2, 6],
//            [1, 1, 6]
//            ]
//    示例 2:
//    输入: candidates = [2,5,2,1,2], target = 5,
//    所求解集为:
//            [
//              [1,2,2],
//              [5]
//            ]

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        
        backtracking(candidates,target,0,used);
        return resulr;
    }

    List<List<Integer>> resulr = new ArrayList<List<Integer>>();
    Deque<Integer> path = new ArrayDeque<Integer>();

    public void backtracking(int[]candidates,int target,int startIndex,boolean[] used){
        if (target == 0){
            resulr.add(new ArrayList<Integer>(path));
        }
        for (int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.addLast(candidates[i]);
            used[i] = true;
            backtracking(candidates,target-candidates[i],i+1,used);
            used[i] = false;
            path.removeLast();
        }
    }
    
}
