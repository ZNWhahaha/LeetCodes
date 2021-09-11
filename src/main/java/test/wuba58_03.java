package test;

import java.util.Arrays;

public class wuba58_03 {
    public static int[] threeSumClosest (int[] A, int T) {
        int[] result = new int[2];
        Arrays.sort(A);
        s:for (int i = 0; i < A[A.length-1]; i++) {
            int a = threeSum(A,T-i);
            int b = threeSum(A,T+i);
            if (a != 0 || b != 0){
                if (T-i == T+i){
                    result[0] = i;
                    result[1] = a;
                }
                else {
                    result[0] = i;
                    result[1] = a+b;
                }
                break s;
            }
        }
        return result;
    }

    private static int threeSum(int[] A, int T){
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > T)
                return result;
            if (i>0 && A[i] == A[i-1])
                continue;
            int left = i+1;
            int right = A.length-1;
            while (left < right){
                int sum = A[i] + A[left] + A[right];
                if (sum > T)
                    right--;
                else if (sum < T)
                    left ++;
                else {
                    result += 1;
                    while (right > left && A[right] == A[right-1])
                        right--;
                    while (right > left && A[left] == A[left+1])
                        left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1,2,1,-4,7};
        int[] res = threeSumClosest(A,1);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
