import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_144 {

//    给你二叉树的根节点 root ，返回它节点值的前序遍历。

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
        return result;
    }

    public void traversal(TreeNode cur, List<Integer> result){
        if (cur == null)
            return;
        result.add(cur.val);
        traversal(cur.left,result);
        traversal(cur.right,result);
    }

    public List<Integer> preorderTraversal_1(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        st.push(root);
        while (!st.empty()){
            TreeNode node = st.peek();
            st.pop();
            if (node != null){
                result.add(node.val);
                st.push(node.right);
                st.push(node.left);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal_2(TreeNode root){
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
                //左
                if (node.left != null)
                    st.push(node.left);
                //中
                st.push(node);
                st.push(null);
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
