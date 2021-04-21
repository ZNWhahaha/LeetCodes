import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_94 {
    //    给定一个二叉树，返回它的中序遍历。

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
        return result;
    }

    private void traversal(TreeNode cur,List<Integer> res){
        if (cur == null)
            return;
        traversal(cur.left,res);
        res.add(cur.val);
        traversal(cur.right,res);
    }
    
    public List<Integer> inorderTraversal_1(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !st.empty()){
            if (cur != null){
                st.push(cur);
                cur = cur.left;
            }
            else {
                cur = st.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }


    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null)
            st.push(root);
        while (!st.empty()){
            TreeNode node = st.peek();
            if (node != null){
                st.pop();
                //右
                if (node.right != null)
                    st.push(node.right);
                //中
                st.push(node);
                st.push(null);
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
