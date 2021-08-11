package SwordFingerOffer;

import java.util.Arrays;

public class offer_04 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=3) {
            if (i == nums.length-1)
                return nums[i];
            else if (nums[i] != nums[i+1])
                return nums[i];
        }
        return 0;
    }

    public int singleNumber_1(int[] nums) {
        Arrays.sort(nums);
        int left=0, right=2;
        int len=nums.length;
        while(right < len){
            if(nums[left] != nums[right])
                return nums[left];
            left=left+3;
            right=left+2;
        }
        return nums[left];
    }
}
