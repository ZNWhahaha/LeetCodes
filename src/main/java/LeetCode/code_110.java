package LeetCode;

public class code_110 {

//    给定一个二叉树，判断它是否是高度平衡的二叉树。
//    本题中，一棵高度平衡二叉树定义为：
//    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1

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

    public boolean isBalanced(TreeNode root) {
        return getHigh(root) == -1 ? false : true;
    }

    private int getHigh(TreeNode node){
        if (node == null)
            return 0;
        int lefthigh = getHigh(node.left);
        if (lefthigh == -1)
            return -1;
        int righthigh = getHigh(node.right);
        if (righthigh == -1)
            return -1;
        return Math.abs(lefthigh - righthigh) > 1 ? -1 : 1 + Math.max(lefthigh,righthigh);
    }
}
