package SwordFingerOffer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_42 {
    Queue<Integer> q = new LinkedList<>();
    int q_len = 0;

    public offer_42()
    {
    }

    public int ping(int t)
    {
        q.offer(t);
        q_len ++;
        while (q.peek() < t - 3000)
        {
            q.poll();
            q_len --;
        }
        return q_len;
    }
}
