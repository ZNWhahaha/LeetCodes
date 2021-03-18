import java.util.Scanner;

public class hj_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            int len = 0;
            while (num > 0) {
                if ((num & 1) == 1){
                    len+=1;
                }
                num = num>>1;
            }
            System.out.println(len);
        }
    }
}
