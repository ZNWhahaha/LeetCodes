import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class hj_14 {
    public static void main_1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int  length = Integer.parseInt(in.nextLine());
            String[] strs = new String[length];
            for (int i = 0; i < length; i++) {
                strs[i] = in.nextLine();
            }
            Arrays.sort(strs);
            for (int i = 0; i < length; i++) {
                System.out.println(strs[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(bf.readLine());
        String[] result=new String[count];
        for(int i=0;i<count;i++)result[i]=bf.readLine();
        StringBuilder sb=new StringBuilder();
        Arrays.sort(result);
        for (String w : result) sb.append(w).append('\n');
        System.out.println(sb.toString());
    }
}
