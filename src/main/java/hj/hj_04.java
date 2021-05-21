package hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class hj_04 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            StringBuilder sb = new StringBuilder();
            String str = in.nextLine();
            sb.append(str);
            int addzero = 8 - str.length() % 8;
            while (addzero > 0 && addzero < 8){
                sb.append('0');
                addzero--;
            }
            String str1 = sb.toString();
            while (str1.length()>0){
                System.out.println(str1.substring(0,8));
                str1 = str1.substring(8);
            }
        }
    }
    public static void main_1(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ( (str=bf.readLine()) != null) {
            int len = str.length();
            int start = 0;
            while (len > 8) {
                System.out.println(str.substring(start, start + 8));
                start += 8;
                len -= 8;
            }
            if (len > 0) {
                char[] tmp = {'0', '0', '0', '0', '0', '0', '0', '0'};
                for (int i = 0; start < str.length(); i++) {
                    tmp[i] = str.charAt(start++);
                }
                System.out.println(String.valueOf(tmp));
            }
        }
    }
}
