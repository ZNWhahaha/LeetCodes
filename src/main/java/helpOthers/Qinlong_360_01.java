package helpOthers;

import java.util.Scanner;

public class Qinlong_360_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
//        for (int i = 0; i < len; i++) {
//            result = Math.max(result,check(nums,i));
//        }
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    public static int check(int[] nums, int index){
        int left = index-1;
        int right = index+1;
        int result = 0;
        while (left >= 0){
            if (nums[left] < nums[index])
                result ++;

            left --;
        }
        while (right < nums.length){
            if (nums[right] < nums[index])
                result ++;

            right ++;                                                       
        }
        return result;
    }

    public static int check_1(int[] nums, int index){
        int left = index-1;
        int right = index+1;
        int result_left = 0;
        int result_right = 0;
        int flag = 0;
        int result = 0;
        while (left >= 0){
            if (nums[left] < nums[index])
                result_left ++;
            if (nums[left] > nums[left+1])
                flag = 1;
            left --;
        }
        if (flag == 1)
            result += result_left;
        flag = 0;
        while (right < nums.length){
            if (nums[right] < nums[index])
                result_right ++;
            if (nums[right] > nums[right-1])
                flag = 1;
            right ++;
        }
        if (flag == 1)
            result += result_right;
        return result;
    }

}
