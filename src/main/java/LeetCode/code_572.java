package LeetCode;

public class code_572 {

//    给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return bfs(s,t);
    }

    private boolean bfs(TreeNode s,TreeNode t){
        if (s == null)
            return false;
        return compare(s,t) || bfs(s.left,t) || bfs(s.right,t);
    }

    private boolean compare(TreeNode leftnode,TreeNode rightnode){
        if (leftnode == null && rightnode == null)
            return true;
        else if (leftnode == null || rightnode == null || leftnode.val != rightnode.val)
            return false;

        boolean leftside = compare(leftnode.left,rightnode.left);
        boolean rightside = compare(leftnode.right,rightnode.right);
        return leftside && rightside;
    }
}
