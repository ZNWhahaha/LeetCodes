package LeetCode;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//        必须 原地 修改，只允许使用额外常数空间。

public class code_31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i>=0 && nums[i]>= nums[i-1])
            i--;
        if (i >= 0){
            int j = nums.length-1;
            while (j >= 0 && nums[i] >= nums[j])
                j--;
            swapNum(nums,i,j);
        }
        reverse(nums,i+1);
    }

    private void swapNum(int[] num,int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void reverse(int[] num,int start){
        int left = start;
        int right = num.length-1;
        while (left < right){
            swapNum(num,start,right);
            start++;
            right--;
        }
    }
}
