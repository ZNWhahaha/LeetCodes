package SwordFingerOffer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_41 {
    Queue<Integer> q = new LinkedList<>();
    int q_len = 0;
    int q_sum = 0;
    int max_size;

    public offer_41(int size) {
        this.max_size = size;
    }

    public double next(int val) {
        q.offer(val);
        q_len ++;
        q_sum += val;

        if (q_len > max_size)
        {
            int x = q.poll();
            q_len --;
            q_sum -= x;
        }

        return (double)q_sum / q_len;
    }
}
