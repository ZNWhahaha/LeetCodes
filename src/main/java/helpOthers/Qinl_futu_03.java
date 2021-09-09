package helpOthers;

import java.util.Scanner;

public class Qinl_futu_03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = min(a, b);
        int n = a * b / m;
        System.out.print(n);
    }
    public static int min(int a, int b){
        if(a < b){
            int t = a;
            a = b;
            b = t;
        }
        while(b != 0){
            if(a == b){
                return a;
            }else{
                int k = a % b;
                a = b;
                b = k;
            }
        }
        return a;
    }

}
