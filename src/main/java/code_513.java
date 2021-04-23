import javax.xml.bind.annotation.XmlType;
import java.util.ArrayDeque;
import java.util.Deque;

public class code_513 {

//    给定一个二叉树，在树的最后一行找到最左边的值。

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

    public int findBottomLeftValue_1(TreeNode root) {
        Deque<TreeNode> dt = new ArrayDeque<>();
        dt.addLast(root);
        int result = 0;
        while (!dt.isEmpty()){
            int size = dt.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dt.getFirst();
                dt.removeFirst();
                if (i == 0)
                    result = node.val;
                if (node.left != null)
                    dt.addLast(node.left);
                if (node.right != null)
                    dt.addLast(node.right);
            }
        }
        return result;
    }

    public int findBottomLeftValue(TreeNode root){
        travelLeftValue(root,0);
        return maxleftvalue;
    }

    int maxlen = Integer.MIN_VALUE;
    int maxleftvalue;
    private void travelLeftValue(TreeNode node,int leftlen) {
        if (node.left == null && node.right == null){
            if (leftlen > maxlen){
                maxleftvalue = node.val;
                maxlen = leftlen;
                return;
            }
        }

        if (node.left != null){
            leftlen ++;
            travelLeftValue(node.left,leftlen);
            leftlen --;
        }
        if (node.right != null){
            leftlen ++;
            travelLeftValue(node.right,leftlen);
            leftlen --;
        }
        return;
    }
}
