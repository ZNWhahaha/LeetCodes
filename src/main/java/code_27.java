public class code_27 {
    public int removeElement(int[] nums, int val) {
        int lowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] == val){
                continue;
            }
            lowIndex++;
            nums[lowIndex] = nums[fastIndex];
        }
        return lowIndex;
    }
}
