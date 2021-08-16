package SwordFingerOffer;

import java.util.HashMap;

public class offer_10 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int pre = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int n : nums){
            pre += n;
            if (map.containsKey(pre - k))
                result += map.get(pre - k);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return result;
    }
}
