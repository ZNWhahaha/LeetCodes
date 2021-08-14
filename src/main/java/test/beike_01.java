package test;

import java.util.Arrays;

public class beike_01 {

    public long[] FarmerNN (int n, long m) {
        long[] ret = new long[n];
        long base = m / (n - 1);
        ret[n-1] = base >> 1;
        ret[0] = (base >> 1) + (base & 1);
        Arrays.fill(ret, 1, n -1, base);
        int cur = 0, step = 1;
        if ((base & 1) == 1) {
            cur= n - 1;
            step = -1;
        }
        long left = m % (n - 1);
        while(left-- > 0) {
            ret[cur]++;
            cur += step;
        }
        return ret;
    }
}
