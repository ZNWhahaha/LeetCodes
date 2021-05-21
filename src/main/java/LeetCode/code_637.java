package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_637 {

//    给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> dt = new ArrayDeque<>();
        if (root != null)
            dt.addLast(root);
        while (!dt.isEmpty()){
            int size = dt.size();
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = dt.getFirst();
                dt.removeFirst();
                sum += node.val;
                if (node.left != null)
                    dt.addLast(node.left);
                if (node.right != null)
                    dt.addLast(node.right);
            }
            result.add((double) (sum/size));
        }
        return result;
    }
}
