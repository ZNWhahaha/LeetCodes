package hj;

import java.util.Scanner;

public class hj_48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str1 = in.nextLine();
            String[] strArray = str1.split(" ");
            int n = Integer.parseInt(strArray[0]);
            int head = Integer.parseInt(strArray[1]);
            int[] index = new int[10000];
            for (int i = 0; i < index.length; i++) {
                index[i] = 10001;
            }
            for (int i = 1; i < n; i++) {
                int v1 = Integer.parseInt(strArray[2 * i]);
                int v2 = Integer.parseInt(strArray[2 * i + 1]);
                int next = index[v2];
                if (next < 10000) {
                    index[v1] = next;
                    index[v2] = v1;
                } else {
                    index[v2] = v1;
                }
            }
            int ti = head;
            int delete = Integer.parseInt(strArray[2 * n]);
            StringBuilder resultBuilder = new StringBuilder();
            while (ti < 10000) {
                if (ti != delete) {
                    resultBuilder.append(ti).append(" ");
                }
                ti = index[ti];
            }
            if (resultBuilder.length() == n) {
                System.out.println();
            } else {
                System.out.println(resultBuilder.toString());
            }
        }
    }
}
