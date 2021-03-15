import java.util.Scanner;

public class hj_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String num = in.next();
            int index = num.indexOf(".");
            if(Integer.parseInt(num.substring(index+1, index+2)) >= 5){
                System.out.println(Integer.parseInt(num.substring(0,index))+1);
            }
            else
                System.out.println(Integer.parseInt(num.substring(0,index)));
        }
    }
}
