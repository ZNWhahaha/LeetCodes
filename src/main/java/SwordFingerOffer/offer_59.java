package SwordFingerOffer;

import java.util.PriorityQueue;

public class offer_59 {
    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public offer_59(int k, int[] nums)
    {
        this.k = k;
        for (int x : nums)
            minHeap.offer(x);
    }

    public int add(int val)
    {
        minHeap.offer(val);

        while (minHeap.size() > k)
            minHeap.poll();

        return minHeap.peek();
    }
}
