public class code_701 {

//    给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
//    注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。

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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (val < root.val)
            root.left = insertIntoBST(root.left,val);
        else if (val > root.val)
            root.right = insertIntoBST(root.right,val);
        return root;
    }

    public TreeNode insertIntoBST_1(TreeNode root, int val){
        if (root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode cur = root;
        TreeNode pre = root;
        while (cur != null){
            pre = cur;
            if (val < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        TreeNode node = new TreeNode(val);
        if (val > pre.val)
            pre.right = node;
        else
            pre.left = node;
        return root;
    }
}
