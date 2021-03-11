import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return lists;
            }
            if (i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            int left = i + 1,
                    right = nums.length - 1;
            while (left < right){

                if (nums[i] + nums[left] + nums[right] > 0)
                    right--;
                else if (nums[i] + nums[left] + nums[right] < 0)
                    left++;
                else {
                    lists.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    right--;
                    left++;
                }
            }
        }

        return lists;
    }
}
