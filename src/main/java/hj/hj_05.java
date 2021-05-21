package hj;

import java.util.Scanner;

public class hj_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            int num = 0;
            int len = a.length();
            for(int i= 1 ; i <= len -2;i++){
                char stander = a.charAt(len-i);
                if(stander > 64 && stander < 91){
                    stander -= 55;
                }
                else if (stander > 96 && stander <122){
                    stander -= 87;
                }
                else {
                    stander -= 48;
                }
                num += stander * Math.pow(16,i-1);
            }
            System.out.println(num);
        }
    }
}
