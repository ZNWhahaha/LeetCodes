package hj;

//密码要求:
//
//        1.长度超过8位
//
//        2.包括大小写字母.数字.其它符号,以上四种至少三种
//
//        3.不能有相同长度大于2的子串重复
//
//        输入描述:
//        一组或多组长度超过2的字符串。每组占一行
//
//        输出描述:
//        如果符合要求输出：OK，否则输出NG

import java.util.Scanner;

public class hj_20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String password = in.nextLine();
            if (checkPWLength(password) && checkPWType(password) && checkPWSame(password))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
    }

    private static boolean checkPWLength(String pw){
        if (pw.length() <= 8)
            return false;
        return true;
    }

    private static boolean checkPWType(String pw){
        int[] type = new int[4];
        for (char c : pw.toCharArray()){
            if (c - '0' >= 0 && c - '0' <= 9)
                type[0] += 1;
            else if (c >= 'A' && c <= 'Z')
                type[1] += 1;
            else if (c >= 'a' && c <= 'z')
                type[2] += 1;
            else
                type[3] += 1;
        }
        int sum = 0;
        for (int t : type){
            if (t != 0)
                sum += 1;
        }
        if (sum >= 3)
            return true;
        return false;
    }

    private static boolean checkPWSame(String pw){
        for (int i = 0; i < pw.length()-4; i++) {
            for (int j = i+1; j < pw.length()-3; j++) {
                if (pw.substring(i,i+3).equals(pw.substring(j,j+3)))
                    return false;
            }
        }
        return true;
    }
}
