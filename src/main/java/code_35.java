public class code_35 {
    public int searchInsert(int[] nums, int target) {
        int index = 0,
                i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] < target){
                continue;
            }
            index = i;
            break;
        }
        if (i > nums.length -1)
            index = nums.length;
        return index;
    }

    public int searchInsert_1(int[] nums, int target) {
        int left = 0,
                right =nums.length -1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] > target){
                right = middle - 1;
            }
            else if (nums[middle] < target){
                left = middle + 1;
            }
            else
                return middle;
        }
        return right -1;
    }
}
