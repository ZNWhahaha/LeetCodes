package hj;

import java.util.Scanner;

public class hj_33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String[] ip = str.split("\\.");
            long num = Long.parseLong(in.nextLine());
            //转10进制
            System.out.println(Long.parseLong(ip[0]) << 24 | Long.parseLong(ip[1]) << 16 |
                    Long.parseLong(ip[2]) << 8 | Long.parseLong(ip[3]));
            //转ip地址
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf((num >> 24) & 255)).append(".").append(String.valueOf((num >> 16) & 255))
                    .append(".").append(String.valueOf((num >> 8) & 255)).append(".").append(String.valueOf(num & 255));
            System.out.println(sb.toString());
        }
    }
}
