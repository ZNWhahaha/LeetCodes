package LeetCode;

import java.util.*;

public class code_77 {

//    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//    示例:
//    输入: n = 4, k = 2
//    输出:
//            [
//            [2,4],
//            [3,4],
//            [2,3],
//            [1,2],
//            [1,3],
//            [1,4],
//            ]

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<Integer> path = new ArrayDeque<Integer>();

    public void backtracking(int n,int k,int startIndex){
        if (path.size() == k){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k -path.size() - 1); i++) {
            path.addLast(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }

    }

}
