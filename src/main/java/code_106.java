import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class code_106 {

//    根据一棵树的中序遍历与后序遍历构造二叉树。
//
//    注意:
//    你可以假设树中没有重复的元素。
//
//    例如，给出
//
//    中序遍历 inorder = [9,3,15,20,7]
//    后序遍历 postorder = [9,15,7,20,3]

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

    int[] inorder;
    int[] postorder;
    HashMap<Integer,Integer> inOrderIndex = new HashMap<>();
    int postIndex;
    

    private TreeNode traversal(int leftInorder, int rightInorder) {
        if (leftInorder > rightInorder)
            return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int i = inOrderIndex.get(rootVal);
        //在通过后序遍历与中序遍历确定二叉树是，需要先对left边赋值，在对right边赋值，
        //原因在于：使用pIndex每次减1时，先读取到的是右子树的节点，当右子树为空时，读左子树节点。
        root.right = traversal(i+1,rightInorder);
        root.left = traversal(leftInorder,i-1);
        return root;
    }

    public TreeNode buildTree(int[] inorder,int[] postorder){
        this.postorder = postorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i],i);
        }
        postIndex = postorder.length-1;
        return traversal(0,postIndex);
    }

    //迭代法
    public TreeNode buildTree_1(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }

}
