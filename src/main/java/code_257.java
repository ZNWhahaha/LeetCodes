import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_257 {

//    给定一个二叉树，返回所有从根节点到叶子节点的路径。
//    说明: 叶子节点是指没有子节点的节点。

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

    public List<String> binaryTreePaths_1(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> st = new Stack<>();
        Stack<String> path = new Stack<>();
        List<String> result = new ArrayList<>();
        st.add(root);
        path.push(String.valueOf(root.val));
        while (!st.empty()){
            TreeNode node = st.pop();
            String pa = path.pop();
            if (node.left == null && node.right == null)
                result.add(pa);
            if (node.right != null){
                st.push((node.right));
                path.push(pa + "->" + node.right.val);
            }
            if (node.left != null){
                st.push(node.left);
                path.push(pa + "->" + node.left.val);
            }
        }
        return result;
    }

    private void traversal(TreeNode node,List<String> path,List<String> result){
        path.add(String.valueOf(node.val));
        if (node.left == null && node.right == null){
            StringBuilder sbpath = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sbpath.append(path.get(i) + "->");
            }
            sbpath.append(path.get(path.size()-1));
            result.add(sbpath.toString());
        }
        if (node.left != null){
            traversal(node.left,path,result);
            path.remove(path.size()-1);
        }
        if (node.right != null){
            traversal(node.right,path,result);
            path.remove(path.size()-1);
        }
    }

    public List<String> binaryTreePaths(TreeNode root){

        List<String> path = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        traversal(root,path,result);
        return result;
    }
}
