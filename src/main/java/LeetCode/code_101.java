package LeetCode;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_101 {

//    给定一个二叉树，检查它是否是镜像对称的
    
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
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return compareNode(root.left,root.right);
    }

    private boolean compareNode(TreeNode left,TreeNode right){
        if (left == null && right != null)
            return false;
        else if (left != null && right == null)
            return false;
        else if (left == null && right == null)
            return true;
        else if (left.val != right.val)
            return false;

        boolean outsaid = compareNode(left.left,right.right);
        boolean insaid = compareNode(left.right,right.left);
        boolean isSame = outsaid && insaid;
        return isSame;
    }

    public boolean isSymmetric_1(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while (!st.empty()){
            TreeNode left = st.pop();
            TreeNode right = st.pop();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || (left.val != right.val))
                return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
        }
        return true;
    }
}
