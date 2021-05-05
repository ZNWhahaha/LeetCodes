public class code_654 {

//    给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
//    二叉树的根是数组 nums 中的最大元素。
//    左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
//    右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。

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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums,0,nums.length);
    }

    private TreeNode traversal(int[] nums,int left,int right){
        if (left >= right)
            return null;

        int maxValueIndex= left;
        for (int i = left+1; i < right; i++) {
            if (nums[i] > nums[maxValueIndex])
                maxValueIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        root.left = traversal(nums,left,maxValueIndex);
        root.right = traversal(nums,maxValueIndex+1,right);
        return root;
    }
}
