package LeetCode;

//实现 int sqrt(int x) 函数。

public class code_69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid = 0;
        int result = -1;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (mid * mid <= x){
                left = mid + 1;
                result = mid;
            }
            else
                right = mid - 1;
        }
        return result;
    }
}
