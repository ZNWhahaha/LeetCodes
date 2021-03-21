import java.util.Scanner;

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

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(climbStairs(n));
    }
}
