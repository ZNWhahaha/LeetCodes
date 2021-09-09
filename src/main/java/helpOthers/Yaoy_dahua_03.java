package helpOthers;

import java.util.Scanner;

public class Yaoy_dahua_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int sn = s.length();
        String ls = s.toLowerCase();

        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < sn; i ++)
        {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isLetter(c))
                ss.append(Character.toLowerCase(c));
        }

        int n = ss.length();
        int l = 0;
        int r = n - 1;
        while (l < r)
        {
            if (ss.charAt(l) != ss.charAt(r)){
                System.out.println("false");
                return;
            }

            l ++;
            r --;
        }
        System.out.println("true");
    }
}
