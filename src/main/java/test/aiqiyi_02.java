package test;

import java.util.Arrays;
import java.util.Scanner;

public class aiqiyi_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String tmp = in.nextLine();
            int k = Integer.parseInt(tmp.split(":")[1]);
            String[] tmpNums = tmp.split(":")[0].split(",");
            int[] nums = new int[tmpNums.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(tmpNums[i]);
            }
            int[] ave = findaves(nums,k);
            double result = Double.MIN_VALUE;
            for (int i = 1; i < ave.length; i++) {
                double value = (ave[i] - ave[i-1]) / (ave[i-1] * 1.0) * 100;
                result = Double.max(value,result);
            }
            System.out.println(String.format("%.2f", result)+"%");
        }
    }

    public static int[] findaves(int[] nums, int k){
        int[] result = new int[nums.length-k];

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        for (int i = 1; i <= nums.length - k; i++) {
            result[i-1] = nums[i+k-1] - nums[i-1];
        }
        return result;
    }
}
