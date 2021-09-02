package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Xiaomi_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> numsList = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            numsList.add(i);
        }
        int index = 0;
        int len = n;
        while (len > 1){
            for (int i = 0; i < numsList.size(); i++) {
                index ++;
                if (index % 3 == 0){
                    numsList.set(i,0);
                    len -= 1;
                }

            }
            tmp.clear();
            for (int t : numsList){
                if (t != 0)
                    tmp.add(t);
            }
            numsList.clear();
            numsList.addAll(tmp);
        }
        System.out.println(numsList.get(0));
    }
}
