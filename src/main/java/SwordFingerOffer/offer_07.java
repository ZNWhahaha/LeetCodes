package SwordFingerOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class offer_07 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resule = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return resule;
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int left = i+1;
            int right = nums.length-1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left ++;
                else {
                    resule.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while (right > left && nums[right] == nums[right-1])
                        right -= 1;
                    while (right > left && nums[left] == nums[left+1])
                        left += 1;

                    right -= 1;
                    left += 1;
                }
            }
        }
        return resule;
    }
}
