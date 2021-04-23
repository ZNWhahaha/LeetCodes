import java.util.*;

public class code_113 {

//    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return result;
        path.addLast(root.val);
        travelpathSum(root,targetSum - root.val);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    private void travelpathSum(TreeNode node,int count) {
        if (node.left == null && node.right == null && count == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if (node.left == null && node.right == null)
            return;

        if (node.left != null){
            path.addLast(node.left.val);
            count -= node.left.val;
            travelpathSum(node.left,count);
            count += node.left.val;
            path.removeLast();
        }

        if (node.right != null){
            path.addLast(node.right.val);
            count -= node.right.val;
            travelpathSum(node.right,count);
            count += node.right.val;
            path.removeLast();
        }
            
    }
}
