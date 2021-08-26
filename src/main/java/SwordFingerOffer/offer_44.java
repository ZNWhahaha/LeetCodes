package SwordFingerOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class offer_44 {
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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> que = new LinkedList<>();
        que.push(root);
        while (!que.isEmpty()){
            int size = que.size();
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
            result.add(max);
        }
        return result;
    }
}
