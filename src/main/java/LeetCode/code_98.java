package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class code_98 {

//    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//    假设一个二叉搜索树具有如下特征：
//
//    节点的左子树只包含小于当前节点的数。
//    节点的右子树只包含大于当前节点的数。
//    所有左子树和右子树自身必须也是二叉搜索树。

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

    TreeNode prenode = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean left = isValidBST(root.left);

        if (prenode != null && prenode.val >= root.val)
            return false;
        prenode = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public boolean isValidBST_1(TreeNode root){
        Deque<TreeNode> dt = new LinkedList<>();
        TreeNode prenode= null;
        TreeNode curnode = root;
        while (curnode != null || !dt.isEmpty()){
            if (curnode != null){
                dt.push(curnode);
                curnode = curnode.left;
            }
            else {
                curnode = dt.pop();
                if (prenode != null && prenode.val >= curnode.val)
                    return false;
                prenode = curnode;
                curnode = curnode.right;
            }
            
        }
        return true;
    }
}
