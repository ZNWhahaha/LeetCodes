package helpOthers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sunmy_wangyi_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> nums_tmp = new ArrayList<>();
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] paper = new int[nums.length];
        Arrays.fill(paper,1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])
                paper[i] = paper[i-1] + 1;
        }

        for (int i = nums.length-2; i >= 0 ; i--) {
            if (nums[i] > nums[i+1])
                paper[i] = Math.max(paper[i],paper[i+1] + 1);
        }

        int result = 0;
        for (int i = 0; i < paper.length; i++) {
            result += paper[i];
        }
        System.out.println(result);

    }
}
