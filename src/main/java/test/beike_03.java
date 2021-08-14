package test;

import java.util.HashMap;
import java.util.Map;

public class beike_03 {
    public long solve(int[] a, int t) {
        int n = a.length;
        long ans = 0;
        Map<Integer, Integer> index = new HashMap<>();
        int pre = 0;
        for (int i = 0; i < n; ++i) {
            int b = a[i] ^ t;
            int k = index.containsKey(b) ? index.get(b) + 1 : 0;
            k = Math.max(k, pre);
            pre = k;
            ans += i - k;
            index.put(a[i],i);
        }
        return ans;
    }
}
