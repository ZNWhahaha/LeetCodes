package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class code_404 {

//    计算给定二叉树的所有左叶子之和。

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

    public int sumOfLeftLeaves_1(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> dt = new ArrayDeque<>();

        dt.addLast(root);
        int sum = root.val;
        while (!dt.isEmpty()){
            int size = dt.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dt.getFirst();
                dt.removeFirst();
                if (node.left != null){
                    if (node.left.left == null && node.left.right == null){
                        sum += node.left.val;
                    }
                    dt.push(node.left);
                }
                if (node.right != null)
                    dt.push(node.right);

            }
        }
        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root){
        if (root == null)
            return 0;
        int leftsum = sumOfLeftLeaves(root.left);
        int rightsum = sumOfLeftLeaves(root.right);
        int midsum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            midsum = root.left.val;
        }
        return leftsum + rightsum + midsum;
    }
    
}
