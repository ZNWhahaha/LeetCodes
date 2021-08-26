package SwordFingerOffer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_48 {
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

    public String serialize(TreeNode root) {
        if (root == null)
            return new String();
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (cur != null){
                    result.append(cur.val).append(",");
                    que.offer(cur.left);
                    que.offer(cur.right);
                }
                else {
                    result.append("null,");
                }
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;

        String [] ss = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        int index = 1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = que.poll();
                if (!ss[index].equals("null"))
                {
                    x.left = new TreeNode(Integer.parseInt(ss[index]));
                    que.offer(x.left);
                }
                index ++;
                if (!ss[index].equals("null"))
                {
                    x.right = new TreeNode(Integer.parseInt(ss[index]));
                    que.offer(x.right);
                }
                index ++;
            }
        }
        return root;
    }
}
