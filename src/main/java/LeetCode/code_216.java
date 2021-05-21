package LeetCode;

import java.util.*;

public class code_216 {

//    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//    说明：
//    所有数字都是正整数。
//    解集不能包含重复的组合。 
//    示例 1:
//    输入: k = 3, n = 7
//    输出: [[1,2,4]]
//    示例 2:
//    输入: k = 3, n = 9
//    输出: [[1,2,6], [1,3,5], [2,3,4]]

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<Integer> path = new ArrayDeque<Integer>();

    public void backtracking(int k,int n,int startIndex,int sum){
        if (sum > n)
            return;

        if (path.size() == k){
            if (sum == n)
                result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = startIndex; i <= n ; i++) {
            sum += i;
            path.addLast(i);
            backtracking(k,n,i+1,sum);
            path.removeLast();
            sum -= i;
        }
        return;
    }
}
