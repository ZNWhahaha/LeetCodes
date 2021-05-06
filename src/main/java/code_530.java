import org.omg.PortableInterceptor.INACTIVE;

import java.util.Deque;
import java.util.LinkedList;

public class code_530 {

//    给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
    
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

    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    private void traversal(TreeNode node){
        if (node == null)
            return;
        traversal(node.left);
        if (pre != null){
            result = Math.min(result,node.val - pre.val);
        }
        pre = node;
        traversal(node.right);
    }

    public int getMinimumDifference_1(TreeNode root) {
        Deque<TreeNode> dt = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;
        while (cur != null || !dt.isEmpty()){
            if (cur != null){
                dt.push(cur);
                cur = cur.left;
            }
            else {
                cur = dt.pop();
                if (pre != null)
                    result = Math.min(result,cur.val-pre.val);
                pre = cur;
                cur = cur.right;
            }
        }
        return result;
    }
}
