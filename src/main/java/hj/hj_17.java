package hj;

import java.util.Scanner;

public class hj_17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] move = in.nextLine().split(";");
            int result1 = 0;
            int result2 = 0;
            for (String str : move) {
                int num = 0;
                if ("".equals(str) || str.length() > 3)
                    continue;
                for (int j = 1; j < str.length(); j++) {
                    int t = str.charAt(j) - '0';
                    if (t >= 0 && t <= 9) {
                        if (j == 1 && str.length() != 2)
                            num += t * 10;
                        else num += t;
                    } else {
                        num = 0;
                        break;
                    }
                }
                char c = str.charAt(0);
                switch (c) {
                    case 'A':
                        result1 -= num;
                        break;
                    case 'D':
                        result1 += num;
                        break;
                    case 'W':
                        result2 += num;
                        break;
                    case 'S':
                        result2 -= num;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(result1 + "," + result2);
        }
    }
}
