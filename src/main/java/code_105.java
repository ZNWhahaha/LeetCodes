import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class code_105 {

//    根据一棵树的前序遍历与中序遍历构造二叉树。
//    注意:
//    你可以假设树中没有重复的元素。

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

    //递归
    int preIndex;
    int[] preorder;
    int[] inorder;
    HashMap<Integer,Integer> inOrderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        preIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i],i);
        }
        return traversal(0,preorder.length-1);
    }

    public TreeNode traversal(int leftInorder, int rightInorder){
        if (leftInorder > rightInorder || preIndex >= preorder.length)
            return null;
        int rootval = preorder[preIndex++];
        TreeNode root = new TreeNode(rootval);
        int i = inOrderIndex.get(rootval);
        //在通过前序遍历与中序遍历确定二叉树是，需要先对left边赋值，在对right边赋值，
        //原因在于：使用proIndex每次加1，先读取到的是左子树的节点，当左子树为空时，读右子树节点。
        root.left = traversal(leftInorder, i-1);
        root.right = traversal(i+1,rightInorder);
        return root;
    }

    //迭代法
    public TreeNode buildTree_1(int[] preorder, int[] inorder){
        if (preorder == null || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> dt = new LinkedList<>();
        dt.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = dt.peek();
            if (node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preorderVal);
                dt.push(node.left);
            }
            else {
                while (!dt.isEmpty() && dt.peek().val == inorder[inorderIndex]){
                    node = dt.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                dt.push(node.right);
            }
        }
        return root;
    }
}
