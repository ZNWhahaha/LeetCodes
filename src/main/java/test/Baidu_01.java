package test;

import java.util.Scanner;

public class Baidu_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] nums = new int[n][n];
        int[][] result = new int[n*k][n*k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = in.nextInt();
                draw(result,i,j,k,nums[i][j]);
            }
        }
        for (int i = 0; i < n*k; i++) {
            for (int j = 0; j < n*k; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void draw(int[][] res,int i,int j,int k,int t){
        for (int l = i*k; l < i*k+k; l++) {
            for (int m = j*k; m < j*k+k; m++) {
                res[l][m] = t;
            }
        }
    }
}
