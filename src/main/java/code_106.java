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

    public class TreeNode {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

    }

}
