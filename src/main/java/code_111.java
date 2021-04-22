import java.util.ArrayDeque;
import java.util.Deque;

public class code_111 {

//    给定一个二叉树，找出其最小深度。
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

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

    public int minDepth_1(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> dt = new ArrayDeque<>();
        dt.addLast(root);
        int depth = 0;
        while (!dt.isEmpty()){
            int size = dt.size();
            int flag = 0;
            depth += 1;
            for (int i = 0; i < size; i++) {
                TreeNode node = dt.getFirst();
                dt.removeFirst();
                if (node.left != null)
                    dt.addLast(node.left);
                if (node.right != null)
                    dt.addLast(node.right);
                if (node.left == null && node.right == null){
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                break;
        }
        return depth;
    }


    public int minDepth(TreeNode root){
        return getDepth(root);
    }

    private int getDepth(TreeNode node){
        if (node == null)
            return 0;
        int leftdepth = getDepth(node.left);
        int rightdepth = getDepth(node.right);

        if (node.left == null && node.right != null)
            return 1+rightdepth;
        if (node.left != null && node.right == null)
            return 1+leftdepth;
        return  1+Math.min(leftdepth,rightdepth);
    }
}
