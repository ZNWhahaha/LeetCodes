import java.util.*;

public class code_332 {

//    给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
//    提示：
//    如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
//    所有的机场都用三个大写字母表示（机场代码）。
//    假定所有机票至少存在一种合理的行程。
//    所有的机票必须都用一次 且 只能用一次。
//    示例 1：
//    输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//    输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
//    示例 2：
//    输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//    输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//    解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets){
            Map<String,Integer> tmp;
            if (map.containsKey(t.get(0))){
                tmp = map.get(t.get(0));
                tmp.put(t.get(1), tmp.getOrDefault(t.get(1), 0) + 1);
            }
            else {
                tmp = new TreeMap<>();
                tmp.put(t.get(1), 1);
            }
            map.put(t.get(0),tmp);
        }
        result.add("JFK");
        backtracking(tickets.size());
        return new ArrayList<>(result);
    }

    private Deque<String> result = new LinkedList<>();
    private Map<String,Map<String,Integer>> map  = new HashMap<String,Map<String,Integer>>();

    private boolean backtracking(int ticketNum){
        if (result.size() == ticketNum +1)
            return true;
        String last = result.getLast();
        if (map.containsKey(last)){
            for (Map.Entry<String, Integer> target:map.get(last).entrySet()){
                int num = target.getValue();
                if (num > 0){
                    result.add(target.getKey());
                    target.setValue(num - 1);
                    if (backtracking(ticketNum))
                        return true;
                    result.removeLast();
                    target.setValue(num);
                }
            }
        }
        return false;
    }
}
