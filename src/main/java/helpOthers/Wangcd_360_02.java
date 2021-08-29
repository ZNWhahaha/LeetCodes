package helpOthers;

import java.util.Scanner;

public class Wangcd_360_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //n 烽火台
        int n = in.nextInt();
        //m 将军
        int m = in.nextInt();
        //x 将军影响范围
        int x = in.nextInt();
        //k 将军提升值
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int result = 0;
    }
}
