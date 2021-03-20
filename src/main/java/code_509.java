public class code_509 {
    public int fib(int n) {
        if (n < 2)
            return n;
        return fib(n - 1) + fib(n - 2);

    }

    public int fib_1(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
