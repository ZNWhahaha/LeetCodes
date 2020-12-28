public class code_1535 {
    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length && count < k; i++) {
            if (arr[i] < max){
                count++;
            }
            else {
                max = arr[i];
                count = 1;
            }
        }
        return max;
    }
}
