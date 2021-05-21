package LeetCode;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class code_145 {

//    给定一个二叉树，返回它的 后序 遍历。

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


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
        return result;
    }

    private void traversal(TreeNode cur,List<Integer> res){
        if (cur == null)
            return;
        traversal(cur.left,res);
        traversal(cur.right,res);
        res.add(cur.val);
    }

    public List<Integer> postorderTraversal_1(TreeNode root) {
        Stack<Integer> result = new Stack<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()){
            TreeNode node = st.peek();
            st.pop();
            if (node != null){
                result.push(node.val);
                st.push(node.left);
                st.push(node.right);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!result.empty()){
            res.add(result.pop());
        }
        return res;
    }

    public List<Integer> postorderTraversal_2(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null)
            st.push(root);
        while (!st.empty()){
            TreeNode node = st.peek();
            if (node != null){
                //中
                st.push(null);
                //右
                if (node.right != null)
                    st.push(node.right);
                //左
                if (node.left != null)
                    st.push(node.left);
            }
            else {
                st.pop();
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
