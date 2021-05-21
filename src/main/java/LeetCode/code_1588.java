package LeetCode;

public class code_1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - i;
            int left_e = (left + 1) / 2;
            int right_e = (right + 1) / 2;
            int left_o = left / 2;
            int right_o = right / 2;
            num += (left_e * right_e + left_o * right_o)  * arr[i];
        }
        return num;
    }
    
}
