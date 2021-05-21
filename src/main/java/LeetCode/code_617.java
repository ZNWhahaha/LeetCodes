package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class code_617 {

//    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//    你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }

    public TreeNode mergeTrees_1(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        Deque<TreeNode> dt = new LinkedList<>();
        dt.push(root1);
        dt.push(root2);
        root1.val += root2.val;
        while (!dt.isEmpty()){
            TreeNode node1 = dt.pop();
            TreeNode node2 = dt.poll();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null){
                dt.push(node1.left);
                dt.push(node2.left);
            }
            if (node1.right != null && node2.right != null){
                dt.push(node1.right);
                dt.push(node2.right);
            }
            if (node1.left == null && node2.left !=null)
                node1.left = node2.left;
            if (node1.right == null && node2.right != null)
                node1.right = node2.right;
        }
        return root1;
    }
}
