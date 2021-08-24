package SwordFingerOffer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_43 {
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


    private TreeNode root;
    private Queue<TreeNode> not_full_nodes = new LinkedList<>();

    public offer_43(TreeNode root)
    {
        this.root = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty())
        {
            TreeNode x = q.poll();
            if (x.left == null || x.right == null)
                not_full_nodes.offer(x);
            if (x.left != null)
                q.offer(x.left);
            if (x.right != null)
                q.offer(x.right);
        }
    }

    public int insert(int v)
    {
        TreeNode x = not_full_nodes.peek();
        if (x.left == null)
        {
            x.left = new TreeNode(v);
            not_full_nodes.offer(x.left);
        }
        else
        {
            x.right = new TreeNode(v);
            not_full_nodes.poll();
            not_full_nodes.offer(x.right);
        }
        return x.val;
    }

    public TreeNode get_root()
    {
        return this.root;
    }
}
