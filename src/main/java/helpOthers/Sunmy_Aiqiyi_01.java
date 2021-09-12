package helpOthers;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Scanner;

public class Sunmy_Aiqiyi_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        int n = in.nextInt();
        int a = in.nextInt();
        tmp = tmp.substring(n,n+a);
        String[] tmp2 = tmp.split("I");
        for (String i : tmp2){
            if (i.length() > 0)
                System.out.println("I"+i);
        }
    }
}
