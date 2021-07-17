package hj;

import java.util.Scanner;


//Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？

public class code_32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
//            String tmp = in.nextLine();
//            if (tmp == null || tmp.length() <2){
//                System.out.println(tmp.length());
//                continue;
//            }
//
//            int maxLen = 1;
//            int sLen = tmp.length();
//            boolean[][] dp = new boolean[sLen][sLen];
//
//            for (int i = 1; i < sLen; i++) {
//                for (int j = 0; j < i; j++) {
//                    if (tmp.charAt(i) == tmp.charAt(j) && (i-j <= 2 || dp[j+1][i-1])){
//                        dp[i][j] = true;
//                    }
//                    if (i - j + 1 > maxLen) {
//                        maxLen = i - j + 1;
//                    }
//                }
//            }
//            System.out.println(maxLen);
            String str = in.nextLine();
            int max=0;
            char[] chars = str.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                //奇数回文
                int left = i-1;
                int right = i+1;
                while(left>=0&&right<= (chars.length-1)&&chars[left]==chars[right]){
                    if(right-left+1>max){
                        max = right-left+1;
                    }
                    left--;
                    right++;
                }
                // 偶数回文
                left = i;
                right = i+1;
                while(left>=0&&right<= (chars.length-1)&&chars[left]==chars[right]){
                    if(right-left+1>max){
                        max = right-left+1;
                    }
                    left--;
                    right++;
                }
            }
            System.out.println(max);
        }
    }
}
