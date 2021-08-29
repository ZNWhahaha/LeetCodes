package helpOthers;

import java.util.Scanner;

public class Sunmy_meituan_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] str1 = in.nextLine().toCharArray();
        char[] str2 = in.nextLine().toCharArray();
        int i=0;
        int index = 0;
        int str1Len = str1.length;
        int str2Len = str2.length;
        while (index < str2Len){
            if (str2[index] == str1[i%str1Len]){
                index++;
            }
            i++;
        }
        System.out.println(i-index);
    }
}
