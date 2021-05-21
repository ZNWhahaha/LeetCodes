package hj;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class hj_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        String str = in.nextLine();
        String finalword = str.split(" ")[str.split(" ").length - 1];
        String[] word_char = finalword.split("");
        System.out.println(word_char.length);
    }

    public static void main_1(String[] args) throws IOException {
        int count = 0;
        InputStream in = System.in;
        char a = (char)in.read();
        while (a != '\n'){
            if (a == ' ')
                count = 0;
            else
                count += 1;
            a = (char)in.read();
        }
        System.out.println(count);
        
    }
}
