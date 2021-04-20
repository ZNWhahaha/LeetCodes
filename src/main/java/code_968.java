public class code_968 {

//    给定一个二叉树，我们在树的节点上安装摄像头
//    节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
//    计算监控树的所有节点所需的最小摄像头数量。
//    示例 1：
//    输入：[0,0,null,0,0]
//    输出：1
//    解释：如图所示，一台摄像头足以监控所有节点。
    
    private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
    
    int result = 0;
    public int traversal (TreeNode root) {
        if (root == null)
            return 2;

        int left = traversal(root.left);    // 左
        int right = traversal(root.right);  // 右
        
        if (left == 2 && right == 2)
            return 0;
        else if (left == 0 || right == 0) {
            result++;
            return 1;
        }
        else
            return 2;
    }

    public int minCameraCover(TreeNode root) {
        result = 0;
        if (traversal(root) == 0) { // root 无覆盖
            result++;
        }
        return result;
    }
}
