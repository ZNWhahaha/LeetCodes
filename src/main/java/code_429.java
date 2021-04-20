import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_429 {

//    给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
//
//    树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。

    class Node {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> dn = new ArrayDeque<>();
        if (root != null)
            dn.addLast(root);
        while (!dn.isEmpty()){
            List<Integer> vec = new ArrayList<>();
            int size = dn.size();
            for (int i = 0; i < size; i++) {
                Node node = dn.getFirst();
                dn.removeFirst();
                if (node != null){
                    vec.add(node.val);
                    for (Node n : node.children){
                        if (n != null)
                            dn.addLast(n);
                    }
                }
            }
            result.add(vec);
        }
        return result;
    }
}
