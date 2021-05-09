import org.omg.CORBA.MARSHAL;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class code_337 {

//    在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

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

    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0],res[1]);
    }

    private int[] robTree(TreeNode cur){
        if (cur == null)
            return new int[]{0,0};
        int[] left = robTree(cur.left) ;
        int[] right = robTree(cur.right);

        int val_1 = cur.val + left[1] + right[1];

        int val_2 = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return new int[]{val_1,val_2};

    }

}
