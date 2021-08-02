package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class code_1488 {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        Map<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            if (rains[i] == 0)
                set.add(i);
            else{
                if (map.containsKey(rains[i])){
                    int preIndex = map.get(rains[i]);
                    Integer zoreIndex = set.higher(preIndex);
                    if (zoreIndex == null)
                        return new int[0];
                    res[zoreIndex] = rains[i];
                    set.remove(zoreIndex);
                }
                map.put(rains[i],i);
                res[i] = -1;
            }
        }
        for(int i = 0; i < len; i++){
            if(res[i] == 0){
                res[i] = 1;
            }
        }
        return res;
    }
}
