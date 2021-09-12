package helpOthers;

import java.util.HashMap;
import java.util.Scanner;

public class Qinl_Aiqiyi_02 {
    private static int sum(int num){
        int a = num % 10;
        int result = a;
        while (num / 10 != 0){
            num /= 10;
            a = num % 10;
            result += a;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer,Integer> check = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int key = sum(i);
            check.put(key,check.getOrDefault(key,0)+1);
        }
        int max = 0;
        for (int i : check.values()){
            max = Math.max(i,max);
        }
        int result = 0;
        for (int i : check.values()){
            if (max == i)
                result ++;
        }
        System.out.println(result);
    }
}
