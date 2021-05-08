import java.util.Stack;

public class code_538 {

//    给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。


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

    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    int pre;
    private void traversal(TreeNode node){
        if (node == null)
            return;
        traversal(node.right);
        node.val += pre;
        pre = node.val;
        traversal(node.left);
    }

    public TreeNode convertBST_1(TreeNode root){
        int pre = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()){
            if (cur != null){
                st.push(cur);
                cur = cur.right;
            }
            else {
                cur = st.pop();
                cur.val += pre;
                pre = cur.val;
                cur = cur.left;
            }
        }
        return root;
    }
}
