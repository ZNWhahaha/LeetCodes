package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class code_226 {

//    翻转一棵二叉树。

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



    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree_1(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root != null)
            st.push(root);
        while (!st.empty()){
            int size = st.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = st.pop();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null)
                    st.push(node.left);
                if (node.right != null)
                    st.push(node.right);
            }
        }
        return root;
    }
}
