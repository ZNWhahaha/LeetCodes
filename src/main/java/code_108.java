import java.util.ArrayDeque;
import java.util.Deque;

public class code_108 {

//    给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//    高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums,0,nums.length-1);
    }

    private TreeNode traversal(int[] nums,int left,int right){
        if (left > right)
            return null;
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums,left,mid-1);
        root.right = traversal(nums,mid+1,right);
        return root;
    }


    public TreeNode sortedArrayToBST_1(int[] nums){
        if (nums.length == 0)
            return null;
        TreeNode root = new TreeNode(0);
        Deque<TreeNode> nodeQue = new ArrayDeque<>();
        Deque<Integer> leftQue = new ArrayDeque<>();
        Deque<Integer> rightQue = new ArrayDeque<>();
        nodeQue.push(root);
        leftQue.push(0);
        rightQue.push(nums.length-1);
        
        while (!nodeQue.isEmpty()){
            TreeNode cur = nodeQue.pop();
            int left = leftQue.pop();
            int right = rightQue.pop();
            int mid = left + ((right-left) / 2);
            cur.val = nums[mid];

            if (left <= mid-1){
                cur.left = new TreeNode(0);
                nodeQue.push(cur.left);
                leftQue.push(left);
                rightQue.push(mid-1);
            }

            if (right >= mid+1){
                cur.right = new TreeNode(0);
                nodeQue.push(cur.right);
                leftQue.push(mid+1);
                rightQue.push(right);
            }
        }
        return root;
    }
}
