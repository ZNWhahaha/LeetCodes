package hj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class hj_27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] words = s.split(" ");
            String str = words[words.length-2];
            int k = Integer.parseInt(words[words.length-1]);

            ArrayList<String> broWords=new ArrayList<>();
            
            for (int i = 1; i < words.length-2; i++){
                if((!words[i].equals(str)) && words[i].length()==str.length()){
                    char[] chStr=str.toCharArray();
                    char[] word=words[i].toCharArray();
                    int temp=0;
                    for (int j = 0; j < chStr.length; j++) {
                        for (int j2 = 0; j2 < word.length; j2++) {
                            if(chStr[j2]=='0')continue;
                            if (word[j]==chStr[j2]) {
                                chStr[j2]='0';
                                temp++;
                                break;
                            }
                        }
                    }
                    if (temp==chStr.length) {
                        broWords.add(words[i]);
                    }
                }
            }
            System.out.println(broWords.size());
            if(k>0 && k<=broWords.size()) {
                Collections.sort(broWords);
                System.out.println(broWords.get(k-1));
            }
        }
    }
}
