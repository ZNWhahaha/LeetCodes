package LeetCode;

import java.util.Stack;

public class code_100 {

//    给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

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

    public boolean isSameTree_1(TreeNode p, TreeNode q) {
        return compare(p,q);
    }

    private boolean compare(TreeNode leftnode,TreeNode rightnode){
        if (leftnode == null && rightnode != null)
            return false;
        else if (leftnode != null && rightnode == null)
            return false;
        else if (leftnode == null && rightnode == null)
             return true;
        else if (leftnode.val != rightnode.val)
             return false;
        boolean outside = compare(leftnode.left,rightnode.left);
        boolean inside = compare(leftnode.right,rightnode.right);
        return outside && inside;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null)
            return false;
        else if (p != null && q == null)
            return false;
        Stack<TreeNode> compareSta = new Stack<>();
        compareSta.push(p);
        compareSta.push(q);
        while (!compareSta.empty()){
            TreeNode node_1 = compareSta.pop();
            TreeNode node_2 = compareSta.pop();
            if (node_1 == null && node_2 == null)
                continue;
            if (node_1 == null || node_2 == null || (node_1.val != node_2.val))
                return false;
            compareSta.push(node_1.left);
            compareSta.push(node_2.left) ;
            compareSta.push(node_1.right);
            compareSta.push(node_2.right);
        }
        return true;
    }
}
