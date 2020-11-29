import java.util.HashMap;

public class code_01 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] index = new int[2];
            HashMap<Integer,Integer> ha = new HashMap<Integer,Integer>();
            for(int i = 0; i < nums.length; i++){
                if(ha.containsKey(nums[i])){
                    index[0] = i;
                    index[1] = ha.get(nums[i]);
                    return index;
                }

                ha.put(target - nums[i],i);
            }
            return index;
        }

    }
}
