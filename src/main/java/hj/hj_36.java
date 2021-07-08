package hj;

import java.util.Scanner;

public class hj_36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String key = in.nextLine();
            String str = in.nextLine();
            char[] chars = key.toLowerCase().toCharArray();
            char[] dict = new char[26];
            int index = 0;
            tag1:
            for (char ch : chars) {
                for (int i = 0; i < index; i++) {
                    if (ch == dict[i]) {
                        continue tag1;
                    }
                }
                dict[index] = ch;
                index++;
            }

            char ch = 'a';
            tag2:
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < index; j++) {
                    if (dict[j] == ch) {
                        ch++;
                        continue tag2;
                    }
                }
                dict[index] = ch;
                ch++;
                index++;
            }

            char[] res = str.toCharArray();
            for (int i = 0; i < res.length; i++) {
                if(res[i] - 'a'>=0){
                    res[i] = dict[res[i] - 'a'];
                }else{
                    res[i] = dict[res[i] - 'A'];
                }

            }

            System.out.println(String.valueOf(res));
        }
    }
}
