package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class code_700 {

//    给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL

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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        TreeNode node = root;
        if (root.val > val)
            node = searchBST(root.left,val);
        else if (root.val < val)
            node = searchBST(root.right,val);
        return node;
    }

    public TreeNode searchBST_1(TreeNode root, int val) {
        if (root == null)
            return  null;
        Deque<TreeNode> dt = new LinkedList<>();
        dt.push(root);
        TreeNode node = null;
        while (!dt.isEmpty()){
            node = dt.pop();
            if (node.val < val)
                dt.push(node.right);
            else if (node.val > val)
                dt.push(node.left);
        }
        return node;
    }

}
