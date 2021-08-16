package SwordFingerOffer;

import java.util.Arrays;

public class offer_11 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] hash = new int[len*2+1];
        Arrays.fill(hash,-2);
        hash[len] = -1;
        int result = 0;
        int presum = len;
        for (int i = 0; i < len; i++) {
            presum += nums[i] == 0 ? -1 : 1;
            if (hash[presum] != -2)
                result = Math.max(result,i-hash[presum]);
            else
                hash[presum] = i;
        }
        return result;
    }
}
