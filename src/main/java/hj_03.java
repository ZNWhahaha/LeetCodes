import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class hj_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            TreeSet ts = new TreeSet();
            int num = in.nextInt();
            for(int i=0; i<num ; i++){
                ts.add(in.nextInt());
            }
            Iterator it = ts.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }

        }
    }
    public static void main_1(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=bf.readLine()) != null){
            boolean[] check = new boolean[1001];
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++) {
                check[Integer.parseInt(bf.readLine())] = true;
            }
            for (int i = 0; i < 1001; i++) {
                if (check[i]){
                    sb.append(i).append("\n");
                }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb.toString());
            }
        }
        
    }
}
