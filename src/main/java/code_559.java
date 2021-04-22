import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_559 {

//    给定一个 N 叉树，找到其最大深度。
//    最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//    N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int depth = 0;
        for (Node node : root.children){
            depth = Math.max(depth,maxDepth(node));
        }
        return 1 + depth;
    }

    public int maxDepth_1(Node root){
        if (root == null)
            return 0;
        Deque<Node> dn = new ArrayDeque<>();
        dn.addLast(root);
        int depth = 0;
        while (!dn.isEmpty()){
            int size = dn.size();
            depth += 1;
            for (int i = 0; i < size; i++) {
                Node node = dn.getFirst();
                dn.removeFirst();
                for (Node n : node.children){
                    if (n != null)
                        dn.addLast(n);
                }
            }
        }
        return depth;
    }
}
