package SwordFingerOffer;

public class offer_12 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if (sum - tmp == tmp - nums[i])
                return i;
        }
        return 0;
    }
}
