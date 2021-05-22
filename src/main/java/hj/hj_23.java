package hj;

//实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
//        注意每个输入文件有多组输入，即多个字符串用回车隔开

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class hj_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            HashMap<Character,Integer> check = new HashMap<Character, Integer>();
            int minNums = 20;
            for (char c : str.toCharArray()){
                check.put(c,check.getOrDefault(c,1)+1);
            }
            for (char key : check.keySet()){
                if (minNums > check.get(key))
                    minNums = check.get(key);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()){
                if (check.get(c) != minNums)
                    sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
