package test;

public class test0722_01 {
//    1。递增数组，查找数字
    private static boolean checkNum(int[] nums, int n){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == n)
                return true;
            else if (nums[mid] < n){
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testNums = new int[]{1,2,3,4,5,6};
        System.out.print(checkNum(testNums,7));
    }
}
