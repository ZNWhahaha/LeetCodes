package hj;

//编写一个程序，将输入字符串中的字符按如下规则排序。
//        规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
//        如，输入： Type 输出： epTy
//        规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
//        如，输入： BabA 输出： aABb
//        规则 3 ：非英文字母的其它字符保持原来的位置。
//        如，输入： By?e 输出： Be?y


import java.util.Scanner;

public class code_26 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            char[] inputChar = input.toCharArray();
            
        }
    }
    
}
