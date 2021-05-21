package LeetCode;

public class code_235 {

//    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//    例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root,p,q);
    }

    private TreeNode traversal(TreeNode node,TreeNode p,TreeNode q){
        if (node == null)
            return null;

        if (node.val > p.val && node.val > q.val){
            TreeNode left = traversal(node.left,p,q);
            if (left != null)
                return left;
        }

        if (node.val < p.val && node.val < q.val){
            TreeNode right = traversal(node.right,p,q);
            if (right != null)
                return right;
        }
        return node;
    }

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q){
        while (root != null){
            if (root.val > p.val && root.val > q.val){
                if (root.left != null)
                    root = root.left;
            }
            else if (root.val < p.val && root.val < q.val){
                if (root.right != null)
                    root = root.right;
            }
            else
                return root;
        }
        return null;
    }
}
