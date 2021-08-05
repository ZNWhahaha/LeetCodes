package hj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class hj_56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String tmp = in.nextLine();
            int num = Integer.parseInt(tmp);
            int result = 0;
            for (int i = 3; i <= num; i++) {
                if (check(i))
                    result += 1;
            }
            System.out.println(result);
        }
    }

    public static boolean check(int num){
        List<Integer> chec = new LinkedList<>();
        for (int i = 1; i <= num / 2 + 1; i++) {
            if (num % i == 0)
                chec.add(i);
        }
        int sum = 0;
        for (int i : chec){
            sum += i;
        }
        return sum == num;
    }
}
