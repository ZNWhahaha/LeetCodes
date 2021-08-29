package helpOthers;

import java.util.List;
import java.util.Scanner;

public class Wangcd_zijie_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        for (int h = 0; h < nums.length; h++) {
            int i=0;
            int sum = 0;
            while(true){
                sum += i;
                if (sum > Math.abs(nums[h][0]-nums[h][1]) && (sum - Math.abs(nums[h][0]-nums[h][1]))%2 == 0){
                    result[h] = i;
                    break;
                }
                i++;
            }
        }
        for (int h : result)
            System.out.println(h);
    }

    private static void travel(int[] nums,int index){
        
    }

}
