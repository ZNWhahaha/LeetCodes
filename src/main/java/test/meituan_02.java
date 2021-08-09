package test;

import java.util.Scanner;

public class meituan_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        tmp = tmp.trim();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            if (result.length() == 0 && tmp.charAt(i) != ' ')
                result.append(tmp.charAt(i));
            else {
                if (result.charAt(result.length()-1) != tmp.charAt(i) && tmp.charAt(i) != ' ')
                    result.append(tmp.charAt(i));
            }
        }
        System.out.println(result.toString());
    }
}
