package SwordFingerOffer;

public class offer_06 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        int left = 0;
        int right = len-1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum > target)
                right -= 1;
            else if (sum < target)
                left += 1;
            else {
                result[0] = left;
                result[1] = right;
                break;
            }
        }
        return result;
    }
}
