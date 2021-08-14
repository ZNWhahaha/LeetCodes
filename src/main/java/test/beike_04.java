package test;

import java.util.HashSet;
import java.util.Set;

public class beike_04 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    Set<String> set;
    int maxV;
    public int maxSubTree (TreeNode root) {
        if (root == null) return 0;
        set = new HashSet<>(); // 存放数的序列化
        maxV = 0;
        travel(root);
        return maxV;
    }

    private String travel(TreeNode rt) {
        if (rt == null) {
            return "#";
        }
        String leftString = travel(rt.left);
        String rightString = travel(rt.right);
        String ret =  "1" + leftString + rightString;
        if (set.contains(ret)) {
            maxV = Math.max(maxV, onesCount(ret));
        } else {
            set.add(ret);
        }
        return ret;
    }

    private int onesCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
