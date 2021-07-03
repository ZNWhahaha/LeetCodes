package hj;

//蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
//        例如，当输入5时，应该输出的三角形为：
//
//        1 3 6 10 15
//
//        2 5 9 14
//
//        4 8 13
//
//        7 12
//
//        11
//        请注意本题含有多组样例输入。

import java.util.Arrays;
import java.util.Scanner;

public class hj_35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            int[][] result = new int[num][num];
            int c = 1;
            for (int i = 0; i < num; i++) {
                int tmp_i = i;
                for (int j = 0; j <= i; j++) {
                    result[tmp_i][j] = c++;
                    tmp_i--;
                }
            }
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num - i; j++) {
                    System.out.print(result[i][j]);
                    if (j != num-i-1)
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
