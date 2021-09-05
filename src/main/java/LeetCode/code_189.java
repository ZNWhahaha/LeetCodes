package LeetCode;

public class code_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k,n-1);
    }

    public void reverse(int[] nums, int startindex, int endindex){
        for (int i=startindex,j=endindex; i < j; i++, j--) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
