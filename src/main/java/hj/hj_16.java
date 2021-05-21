package hj;

import java.util.Scanner;


public class hj_16 {
    //带附加条件的背包问题

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int money = in.nextInt();
            int goods = in.nextInt();
            int[] p = new int[goods];
            int[] v = new int[goods];
            int[] q = new int[goods];
            for (int i = 0; i < goods; i++) {
                p[i] = in.nextInt();
                v[i] = in.nextInt() * p[i];
                q[i] = in.nextInt();
            }
            System.out.println(getMaxValue(v,p,q,money,goods));
        }
    }

    private static int getMaxValue(int[] val,int[] weight,int[] q,int money,int goods){
        int[][] dp = new int[goods+1][money+1];
        for (int i = 1; i <= goods; i++) {
            for (int j = 1; j <= money ; j++) {
                if (q[i-1] == 0){
                    if (j > weight[i-1])
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]] + val[i-1]);
                }
                else {
                    if (j > weight[i - 1] + weight[q[i - 1]])
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]] + val[i-1]);
                }
            }
        }
        return dp[goods][money];
    }
}
