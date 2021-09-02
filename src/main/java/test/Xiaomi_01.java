package test;

import java.util.Scanner;

public class Xiaomi_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] tmp_mn = in.nextLine().split(",");
        String[] numsA = in.nextLine().split(",");
        String[] numsB = in.nextLine().split(",");
        int m = tmp_mn[0].charAt(tmp_mn[0].length()-1) -'0';
        int n = tmp_mn[1].charAt(tmp_mn[1].length()-1) -'0';
        int[] A = new int[m];
        int[] B = new int[n];
        int[] result = new int[m+n];
        for (int i = 0; i < m; i++) {
            A[i] = Integer.parseInt(numsA[i]);
        }
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(numsB[i]);
        }
        int index1 = 0;
        int index2 = 0;
        int cur;
        while (index1 < m || index2 < n){
            if (index1 == m)
                cur = B[index2++];
            else if (index2 == n)
                cur = A[index1++];
            else if (A[index1] < B[index2])
                cur = A[index1++];
            else
                cur = B[index2++];
            result[index1+index2-1] = cur;
        }
        for (int i = 0; i < m+n; i++) {
            System.out.print(result[i] + " ");
        }
        
    }
}
