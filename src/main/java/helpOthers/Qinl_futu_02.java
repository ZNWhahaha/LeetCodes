package helpOthers;

import java.util.Scanner;

public class Qinl_futu_02 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int p = in.nextInt();
            int m = in.nextInt();
            if(n==1){
                System.out.println(0);
            }else{
                System.out.println(2*n-3);
            }
        }
    }
}
