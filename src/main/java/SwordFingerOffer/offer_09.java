package SwordFingerOffer;

public class offer_09 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=0)return 0;
        int left = 0;
        int result = 0;
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            tmp *= nums[i];
            while (tmp >= k && left < nums.length){
                tmp /= nums[left++];
            }
            if (left <= i)
                result += i-left+1;
        }
        return result;
    }
}
