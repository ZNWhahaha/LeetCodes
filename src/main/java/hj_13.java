import java.util.Scanner;

public class hj_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String[] nums = String.valueOf(a).split(" ");
            for (int i = nums.length-1; i >=0 ; i--) {
                System.out.print(nums[i] + " ");
            }
        }
    }
}
