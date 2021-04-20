import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_589 {

//    给定一个 N 叉树，返回其节点值的 前序遍历 。
//
//    N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。



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

    public List<Integer> preorder(Node root) {
        Stack<Node> sn = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null)
            sn.push(root);
        while (!sn.empty()){
            Node node = sn.pop();
            if (node != null){
                result.add(node.val);
                for (int i = node.children.size()-1; i >=0 ; i--) {
                    Node n = node.children.get(i);
                    if (n != null)
                        sn.push(n);
                }
            }
        }
        return result;
    }

    
}
