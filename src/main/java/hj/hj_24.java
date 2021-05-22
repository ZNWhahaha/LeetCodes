package hj;

//计算最少出列多少位同学，使得剩下的同学排成合唱队形
//        说明：
//        N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
//        合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
//        你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
//        注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
//        请注意处理多组输入输出！


import java.util.Arrays;
import java.util.Scanner;

public class hj_24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int peopleLen = in.nextInt();
            if (peopleLen <= 1)
                System.out.println();
            int[] heights = new int[peopleLen];
            for (int i = 0; i < peopleLen ; i++) {
                heights[i] = in.nextInt();
            }
            int[] seq = new int[peopleLen];
            int[] reseq = new int[peopleLen];
            int[] dp = new int[peopleLen];
            
            Arrays.fill(seq, 1);
            for (int i = 0; i < seq.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (heights[i] > heights[j]) {
                        seq[i] = Math.max(seq[i], seq[j] + 1);
                    }
                }
            }

            Arrays.fill(reseq, 1);
            for (int i = reseq.length-1; i>= 0; i--) {
                for (int j = i+1; j < reseq.length; j++) {
                    if (heights[i] > heights[j]) {
                        reseq[i] = Math.max(reseq[i], reseq[j] + 1);
                    }
                }
            }

            for (int i = 0; i < reseq.length; i++) {
                dp[i] = reseq[i] + seq[i];
            }
            int max = 0;
            for (int num : dp){
                if (max < num)
                    max = num;
            }
            System.out.println(peopleLen - max + 1);
        }
    }


}
