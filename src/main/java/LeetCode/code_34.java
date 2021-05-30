package LeetCode;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//        如果数组中不存在目标值 target，返回 [-1, -1]。

public class code_34 {

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false)-1;
        if (leftIndex<=rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target)
            return new int[]{leftIndex,rightIndex};
        return new int[]{-1,-1};
    }

    private int binarySearch(int[] nums,int target,boolean lowwer){
        int ans = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lowwer && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            }
            else
                left = mid + 1;
        }
        return ans;
    }
}
