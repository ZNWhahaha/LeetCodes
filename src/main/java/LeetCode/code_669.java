package LeetCode;

public class code_669 {

//    给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案


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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val < low)
            return trimBST(root.right,low,high);
        if (root.val > high)
            return trimBST(root.left,low,high);

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }

    public TreeNode trimBST_1(TreeNode root, int low, int high){
        if (root == null)
            return null;
        while (root.val < low || root.val > high){
            if (root.val < low)
                root = root.right;
            else if (root.val > high)
                root = root.left;
        }
        TreeNode cur = root;
        while (cur != null){
            while (cur.left != null && cur.left.val < low)
                cur.left = cur.left.right;
            cur = cur.left;
        }
        cur = root;
        while (cur != null){
            while (cur.right != null && cur.right.val > high)
                cur.right = cur.right.left;
            cur = cur.right;
        }
        return root;
    }
}
