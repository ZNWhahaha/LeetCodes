package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class code_222 {

//    给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//    完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点

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

    public int countNodes_1(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        Deque<TreeNode> dt = new ArrayDeque<>();
        dt.addLast(root);
        while (!dt.isEmpty()){
            int size = dt.size();
            for (int i = 0; i < size; i++) {
                count += 1;
                TreeNode node = dt.getFirst();
                dt.removeFirst();
                if (node.left != null)
                    dt.addLast(node.left);
                if (node.right != null)
                    dt.addLast(node.right);
            }
        }
        return count;
    }

    public int countNodes(TreeNode root){
        return getCount(root);
    }

    private int getCount(TreeNode node){
        if (node == null)
            return 0;
        int leftcount = getCount(node.left);
        int rightcount = getCount(node.right);
        return 1 + leftcount + rightcount;
    }
}
