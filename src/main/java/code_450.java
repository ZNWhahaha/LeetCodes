public class code_450 {
//    给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//    一般来说，删除节点可分为两个步骤：
//
//    首先找到需要删除的节点；
//    如果找到了，删除它。
//    说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val == key){
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else{
                TreeNode cur = root.left;
                while (cur != null)
                    cur = cur.left;
                cur.left = root.left;
                root = root.right;
            }
        }
        if (root.val > key)
            root.left = deleteNode(root.left,key);
        else if (root.val < key)
            root.right = deleteNode(root.right,key);
        return root;
    }

    public TreeNode deleteNode_1(TreeNode root, int key){
        if (root == null)
            return root;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null){
            if (cur.val == key)
                break;
            pre = cur;
            if (key > cur.val)
                cur = cur.right;
            else
                cur = cur.left;
        }
        if (pre == null)
            return deleteOneNode(cur);
        if (pre.left != null && pre.left.val == key)
            pre.left = deleteOneNode(cur);
        if (pre.right != null && pre.right.val == key)
            pre.right = deleteOneNode(cur);


        return root;
    }

    private TreeNode deleteOneNode(TreeNode node){
        if (node == null)
            return node;
        if (node.right == null)
            return node.left;
        TreeNode cur = node.right;
        while (cur.left != null)
            cur = cur.left;
        cur.left = node.left;
        return node.right;
    }
}
