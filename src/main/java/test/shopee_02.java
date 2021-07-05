package test;

public class shopee_02 {
    public int petalsBreak(int[] petals) {
        // write code here
        int result = 0;
        for (int i = 0; i < petals.length; i++) {
            result += petals[i] / 2;
            if (petals[i] % 2 == 1)
                result += 1;
        }
        return result;
    }
}
