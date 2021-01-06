import java.util.Arrays;

public class code_628 {
    //解法一：当有正数负数同时存在时，最大值为负数中最小的（数组中前两位）乘以数组中最后一位正数
    //       当全是正数或全是负数时，取末尾3位数即可
    //       通过max函数区分正负的存在
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int num_1 = nums[nums.length -1] * nums[nums.length -2] * nums[nums.length -3];
        int num_2 = nums[0] * nums[1] * nums[nums.length -1];
        return Math.max(num_1,num_2);
    }
    //解法2：遍历一遍数组，取得数组中的最大的三个数相乘即可
    public int maximumProduct_1(int[] nums) {
        int max_1 = Integer.MIN_VALUE,max_2 = Integer.MIN_VALUE,max_3 = Integer.MIN_VALUE;
        int min_1 = Integer.MAX_VALUE,min_2 = Integer.MAX_VALUE;

        for (int num : nums){
            if (num > max_1) {
                max_3 = max_2;
                max_2 = max_1;
                max_1 = num;
            }
            else if (num > max_2){
                max_3 = max_2;
                max_2 = num;
            }
            else if (num > max_3)
                max_3 = num;
            if (num < min_1){
                min_2 = min_1;
                min_1 = num;
            }
            else if (num < min_2)
                min_2 = num;
        }
        return Math.max(max_1 * max_2 * max_3,min_1*min_2*max_1) ;
    }
}
