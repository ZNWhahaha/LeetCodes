package LeetCode;

public class code_738 {

//    给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//            （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
//    示例 1:
//    输入: N = 10
//    输出: 9
//    示例 2:
//    输入: N = 1234
//    输出: 1234

    //暴力破解，超时
    public int monotoneIncreasingDigits(int N) {
        if (N < 10)
            return N;
        int num = N;
        for (; num > 0 ; num--) {
            boolean flag = true;
            char[] nums = Integer.toString(num).toCharArray();
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[j-1]){
                    flag = false;
                    break;
                }
                else
                    flag = true;
            }
            if (flag == true){
                break;
            }
        }
        return num;
    }

    //贪心算法
    public int monotoneIncreasingDigits_1(int N) {
        char[] strNum = Integer.toString(N).toCharArray();
        int flag = strNum.length;
        for (int i = strNum.length -1; i > 0; i--) {
            if (strNum[i] < strNum[i-1]){
                strNum[i-1] -= 1;
                flag = i;
            }
        }
        for (int i = flag; i < strNum.length; i++) {
            strNum[i] = '9';
        }
        return Integer.valueOf(String.valueOf(strNum));
    }
}
