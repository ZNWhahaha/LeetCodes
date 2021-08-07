package hj;

import java.util.Scanner;

public class hj_60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String tmp = in.nextLine();
            int num = Integer.parseInt(tmp.trim());
            for (int i = num/2; i >= 2; i--) {
                if (isPrimer(i) && isPrimer(num-i)){
                    System.out.println(i);
                    System.out.println(num-i);
                    break;
                }
            }
        }
    }

    public static boolean isPrimer(int num){
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
