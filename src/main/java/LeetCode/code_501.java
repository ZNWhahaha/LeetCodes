package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class code_501 {

//    给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
//    假定 BST 有如下定义：
//
//    结点左子树中所含结点的值小于等于当前结点的值
//            结点右子树中所含结点的值大于等于当前结点的值
//    左子树和右子树都是二叉搜索树

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

    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    ArrayList<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] re = new int[result.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = result.get(i);
        }
        return re;
    }

    private void traversal(TreeNode node){
        if (node == null)
            return;
        traversal(node.left);

        if (pre == null)
            count = 1;
        else if (node.val == pre.val)
            count += 1;
        else
            count = 1;
        pre = node;
        if (count == maxCount)
            result.add(node.val);
        if (count > maxCount){
            maxCount = count;
            result.clear();
            result.add(node.val);
        }

        traversal(node.right);
    }


    public int[] findMode_1(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Deque<TreeNode> dt = new ArrayDeque<>();
        int maxCOunt = 0;
        int count = 0;
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !dt.isEmpty()){
            if (cur != null){
                dt.push(cur);
                cur = cur.left;
            }
            else {
                cur = dt.pop();
                if (pre == null)
                    count = 1;
                else if (cur.val == pre.val)
                    count += 1;
                else
                    count = 1;
                pre = cur;
                if (maxCOunt == count)
                    result.add(cur.val);
                if (count > maxCOunt){
                    maxCOunt = count;
                    result.clear();
                    result.add(cur.val);
                }
                cur = cur.right;
            }
        }
        int[] re = new int[result.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = result.get(i);
        }
        return re;
    }
}
