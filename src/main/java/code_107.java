import java.util.*;

public class code_107 {

//    给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> res = new Stack<>();
        Deque<TreeNode> dt = new ArrayDeque<>();

        if (root != null)
            dt.addLast(root);
        while (!dt.isEmpty()){
            List<Integer> vec = new ArrayList<>();
            int size = dt.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dt.getFirst();
                dt.removeFirst();
                vec.add(node.val);
                if (node.left != null)
                    dt.addLast(node.left);
                if (node.right != null)
                    dt.addLast(node.right);
            }
            res.push(vec);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!res.empty()){
            result.add(res.pop());
        }
        return result;
    }
}
