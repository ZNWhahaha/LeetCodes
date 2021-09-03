package helpOthers;

import java.util.Scanner;

public class Qinlong_ali_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int r = i1^i2;
        int result = 0;
        String t = String.valueOf(r);
        if (t.charAt(0) == '1')
            result++;
        for (int i = 1; i < t.length(); i++) {
            if (t.charAt(i) == '1' && t.charAt(i-1)!= '1')
                result++;
        }
        if (r == 0 && !s1.equals(s2))
            result = 1;
        System.out.println(result);
    }
}
