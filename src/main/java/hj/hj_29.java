package hj;

import java.util.Scanner;

public class hj_29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            System.out.println(jiami(a));
            String b = in.nextLine();

            System.out.println(jiemi(b));
        }
    }

    public static String jiemi(String str) {
        char ch[]=str.toCharArray();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<ch.length;i++) {
            if(ch[i]>='a'&&ch[i]<='z') {
                if(ch[i]=='a')
                    sb.append('Z');
                else
                    sb.append((char)(ch[i]-33));

            }
            else if(ch[i]>='A'&&ch[i]<='Z') {
                if(ch[i]=='A')
                    sb.append('z');
                else
                    sb.append((char)(ch[i]+31));
            }
            else if(ch[i]>='0'&&ch[i]<='9') {
                if(ch[i]=='0')
                    sb.append('9');
                else
                    sb.append((char) (ch[i]-1));

            }

        }

        return sb.toString();
    }

    public static String jiami(String str){
        char[] tmp = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] >= 'a' && tmp[i] <= 'z'){
                if (tmp[i] == 'z')
                    sb.append('A');
                else
                    sb.append((char)(tmp[i]-31));
            }
            else if (tmp[i] >= 'A' && tmp[i] <= 'Z'){
                if (tmp[i] == 'Z')
                    sb.append('a');
                else
                    sb.append((char)(tmp[i]+33));
            }
            else if (tmp[i] >= '0' && tmp[i] <= '9'){
                if (tmp[i] == '9')
                    sb.append('0');
                else
                    sb.append((char)(tmp[i]+1));
            }
        }
        return sb.toString();
    }
}
