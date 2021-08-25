package SwordFingerOffer;

import java.util.Deque;
import java.util.LinkedList;

public class offer_45 {
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

    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.push(root);
        int result = 0;
        while (!que.isEmpty()){
            int size = que.size();
            result = que.getFirst().val;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.getFirst();
                que.removeFirst();
                max = Math.max(max,cur.val);
                if (cur.left != null)
                    que.addLast(cur.left);
                if (cur.right != null)
                    que.addLast(cur.right);
            }
        }
        return result;
    }
}
