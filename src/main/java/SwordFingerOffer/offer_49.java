package SwordFingerOffer;

public class offer_49 {
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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        travel(root,0);
        return result;
    }

    private void travel(TreeNode node, int prefix){
        int cur = prefix*10 + node.val;
        if (node.left == null && node.right == null)
        {
            result += cur;
        }
        else{
            if (node.left != null)
                travel(node.left, cur);
            if (node.right != null)
                travel(node.right, cur);
        }
    }
}
