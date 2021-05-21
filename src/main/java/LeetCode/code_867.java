package LeetCode;

public class code_867 {
    public int[][] transpose(int[][] A) {
        int[][] newnums = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                newnums[j][i] = A[i][j];
            }
        }
        return newnums;
    }
}
