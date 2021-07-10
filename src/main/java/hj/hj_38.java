package hj;

import java.util.Scanner;

//假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
//        最后的误差判断是小数点6位

public class hj_38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            Double b = Double.valueOf(a);
            System.out.println(get(b));
            System.out.println(height(b));
        }
    }

    public static double height(double h) {
        for (int i = 0; i < 5; i++) {
            h = h / 2;
        }
        return h;
    }

    public static double get(double h) {
        return h + h + h / 2 + h / 4 + h / 8;
    }
}
