package LeetCode;

//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
//        给你两个整数 x 和 y，计算并返回它们之间的汉明距离。

public class code_461 {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int res = 0;
        while (tmp != 0){
            res += tmp & 1;
            tmp >>= 1;
        }
        return res;
    }
    
    public int hammingDistance_1(int x, int y){
        int tmp = x ^ y;
        int res = 0;
        while (tmp != 0){
            tmp &= tmp - 1;
            res ++;
        }
        return res;
    }
}
