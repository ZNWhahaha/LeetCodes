package hj;

import java.util.Scanner;

public class hj_51 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = Integer.parseInt(in.nextLine());
            String[] numStr = in.nextLine().split(" ");
            int num2 = Integer.parseInt(in.nextLine());
            if(num2<=0||num2>numStr.length){
                System.out.println(num2);
            }else{
                System.out.println(numStr[numStr.length-num2]);
            }
        }
    }
}
