package SwordFingerOffer;

public class offer_47 {
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

    public TreeNode pruneTree(TreeNode root) {
        return travel(root) == 0 ? null : root;
    }

    private int travel(TreeNode node){
        if (node == null)
            return 0;
        int leftindex = travel(node.left);
        int rightindex = travel(node.right);
        if (leftindex == 0)
            node.left = null;
        if (rightindex == 0)
            node.right = null;

        return (leftindex | rightindex | node.val);

    }
}
