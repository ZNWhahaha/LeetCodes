package hj;

//现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
//        每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
//        注：
//        称重重量包括0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class hj_41 {

    static int sum = 0;
    static Set<Integer> res = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] weight = new int[n];
            int[] count = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                count[i] = in.nextInt();
            }
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < weight.length; i++) {
                for (int j = 0; j < count[i]; j++) {
                    tmp.add(weight[i]);
                }
            }
            Integer[] input = new Integer[tmp.size()];
            tmp.toArray(input);
            Arrays.sort(input);
            backtrack(input,0);
            System.out.println(res.size());
            sum = 0;
            res.clear();
        }
    }

    private static void backtrack(Integer[] input, int beg){
        res.add(sum);
        for (int i = beg; i < input.length; i++) {
            if (i > beg && input[i] == input[i-1])
                continue;
            sum += input[i];
            backtrack(input,i+1);
            sum -= input[i];
        }
    }


    public static void main_1(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        while((str=br.readLine())!=null){
            int n=Integer.parseInt(str);
            String[] strs1=br.readLine().split(" ");
            String[] strs2=br.readLine().split(" ");
            int[] weight=new int[strs1.length];
            int[] count=new int[strs2.length];
            int sum=0;
            for(int i=0;i<n;i++){
                weight[i]=Integer.parseInt(strs1[i]);
                count[i]=Integer.parseInt(strs2[i]);
                sum=sum+weight[i]*count[i];
            }
            System.out.println(fama(n,weight,count ,sum));
        }
    }
    public static int fama(int n,int[] weight,int[] count,int sum){
        boolean[] weg=new boolean[sum+1];
        weg[0]=true;
        weg[sum]=true;
        int top=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<count[i];j++){
                for(int k=top+weight[i];k>=weight[i];k--){
                    if(weg[k-weight[i]]){
                        weg[k]=true;
                    }
                }
                top+=weight[i];
            }
        }
        int coun=0;
        for(boolean b:weg){
            if(b) coun++;
        }
        return coun;
    }
}
