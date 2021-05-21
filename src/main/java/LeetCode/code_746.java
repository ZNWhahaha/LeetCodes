package LeetCode;

import java.util.Scanner;

public class code_746 {
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1){
            return cost[cost.length-1];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]) ;
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int[] n_1 = {1,100,1,1,1,100,1,1,100,1};
        int[] n = {10,15,20};
        System.out.println(minCostClimbingStairs(n));
    }
}
