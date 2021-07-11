package hj;

import java.util.Scanner;

public class hj_28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int count = in.nextInt();
            int[] nums = new int[count];
            int oddCount = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = in.nextInt();
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i]%2 == 1){
                    oddCount++;
                }
            }
            int[] odds = new int[oddCount];
            int m = 0;
            int[] evens = new int[count - oddCount];
            int n = 0;
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                if(num % 2 == 0){
                    evens[n++] = num;
                }else{
                    odds[m++] = num;
                }
            }
            int[] evensMatch = new int[count - oddCount];
            int result = 0;
            for(int i = 0; i < odds.length; i++){
                int[] used = new int[evensMatch.length];
                if(find(odds[i], evens, used, evensMatch)){
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    private static boolean check(int num){
        if(num == 1){
            return false;
        }
        for (int i = 2; i < Math.sqrt(num)+1; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static boolean find(int x, int[] evens, int[] used, int[] evensMatch) {
        int j;
        for(j = 0; j < evens.length; j++){
            if(check(x + evens[j]) && used[j] == 0){
                used[j] = 1;
                if(evensMatch[j] == 0 || find(evensMatch[j], evens, used, evensMatch)){
                    evensMatch[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
