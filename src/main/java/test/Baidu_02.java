package test;

import java.util.Scanner;

public class Baidu_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());
        String[] nums = new String[len];
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextLine().replaceFirst("^0*","");
        }
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nums[i].length(); j++) {
                char c = nums[i].charAt(j);
                if (c >= '0' && c <= '9')
                    sb.append(c);
            }
            result[i] = check(sb.toString().toCharArray());
        }
        for (int i = 0; i < len; i++) {
            System.out.println(result[i]);
        }
    }

    public static String check(char[] num){
        if (num.length <= 0)
            return "-1";
        StringBuilder sb = new StringBuilder();

        int len = num.length-1;
        int a = num[len]-'0';
        int[] result = new int[len+1];
        int flag = 0;
        while (true){
            if (a == 0){
                a = 3;
                if (len >= 1)
                    flag = 1;
            }
            else if (a > 3)
                a = 3;
            result[len] = a;
            len--;
            if (len < 0)
                break;
            a = num[len]-'0';
            if (flag == 1 && a == 0){
                a = 9;
            }
            else if (flag == 1){
                a -= 1;
                flag = 0;
            }
            if (len == 0 && a == 0)
                break;
        }
        for(int i : result){
            sb.append(i);
        }
        return sb.toString().replaceFirst("^0*","");
    }
}
