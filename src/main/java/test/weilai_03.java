package test;

import java.math.BigInteger;

public class weilai_03 {

    public static int theNumberofWays (int[] arr, int aim) {

        String[] dp = new String[aim+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = "0";
        }
        dp[0] = "1";
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= aim; j++) {
                String tmp = String.valueOf(Long.valueOf(dp[j]) + Long.valueOf(dp[j - arr[i]]));
                dp[j] = tmp;
            }
        }
        return (int) Math.floorMod(Long.valueOf(dp[aim]), (int) (Math.pow(10,9)+7));
    }

    public static int theNumberofWays_1 (int[] arr, int aim) {

        BigInteger[] dp = new BigInteger[aim+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = BigInteger.valueOf(0);
        }
        dp[0] = BigInteger.valueOf(1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= aim; j++) {
                dp[j] = dp[j].add(dp[j-arr[i]]);
            }
        }
        BigInteger result = dp[aim].mod(BigInteger.valueOf((int) (Math.pow(10,9)+7)));
        return result.intValue();
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,7,10};
        int aim = 15;
        System.out.print(theNumberofWays_1(arr,aim));
    }

}
