import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class code_104 {

//    给定一个二叉树，找出其最大深度。
//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

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

    public int maxDepth_1(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> dt = new ArrayDeque<>();
        dt.addLast(root);
        int depth = 0;
        while (!dt.isEmpty()){
            int size = dt.size();
            depth += 1;
            for (int i = 0; i < size; i++) {
                TreeNode node = dt.getFirst();
                dt.removeFirst();
                if (node.left != null)
                    dt.addLast(node.left);
                if (node.right != null)
                    dt.addLast(node.right);
            }
        }
        return depth;
    }

    public int maxDepth(TreeNode root){
        return getDepth(root);
    }

    private int getDepth(TreeNode node){
        if (node == null)
            return 0;
        int leftdepth = getDepth(node.left);
        int rightdepth = getDepth(node.right);
        return 1 + Math.max(leftdepth,rightdepth);
    }
}
