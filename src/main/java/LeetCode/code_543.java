package LeetCode;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

public class code_543 {
    public class TreeNode {
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

    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        travel(root);
        return result - 1;

    }

    private int travel(TreeNode node) {
        if (node == null)
            return 0;
        int L = travel(node.left);
        int R = travel(node.right);
        result = Math.max(result,L+R+1);
        return Math.max(L,R) + 1;
    }
}

