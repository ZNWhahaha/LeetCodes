package LeetCode;

import java.util.Scanner;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//        注意：给定 n 是一个正整数。
//
//        示例 1：
//
//        输入： 2
//        输出： 2
//        解释： 有两种方法可以爬到楼顶。
//        1.  1 阶 + 1 阶
//        2.  2 阶


public class code_70 {
    public int climbStairs_1(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i -2];
        }
        return  dp[n];
    }
    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
    //用背包问题解决爬楼梯
    public int climbStairs_2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if(i - j >= 0)
                    dp[i] += dp[i-j];
            }
        }
        return dp[n];
    }
    
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(climbStairs(n));
    }
}
