package SwordFingerOffer;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class offer_61 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                minheap.offer(new int[]{nums1[i],nums2[j]});
            }
        }
        int i = 0;
        List<List<Integer>> result = new LinkedList<>();
        while (minheap.size() > 0 && i < k){
            List<Integer> tmp = new LinkedList<>();
            int[] nums = minheap.poll();
            tmp.add(nums[0]);
            tmp.add(nums[1]);
            result.add(tmp);
            i++;
        }
        return result;
    }
}
