package SwordFingerOffer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class offer_60 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n,map.getOrDefault(n,0)+1);
        PriorityQueue<int[]> minhead = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for (Integer key : map.keySet()){
            int num = key;
            int count = map.get(key);
            if (minhead.size() == k ){
                if (minhead.peek()[1] < count){
                    minhead.poll();
                    minhead.offer(new int[]{key,count});
                }
            }
            else
                minhead.offer(new int[]{key,count});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = minhead.poll()[0];
        }
        return result;
    }
}
