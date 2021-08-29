package helpOthers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Sunmy_keda_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        if (n == 1){
            System.out.println(1);
            return;
        }
        int max = run(nums);
        for (int i = 1; i < n; i++) {
            int[] tmp = Arrays.copyOf(nums,n);
            swpa(tmp,i);
            max = Math.max(max,run(tmp));
        }

        System.out.println(max);
    }

    private static void swpa(int[] nums,int i){
        int tmp = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = tmp;
    }

    private static int run(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right;
        int historyCharMax = 0;
        for (right = 0; right < nums.length; right++) {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            historyCharMax = Math.max(historyCharMax, map.get(nums[right]));
            if (right - left + 1 > historyCharMax) {
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
        }
        return nums.length - left;
    }

}
