import com.sun.xml.internal.fastinfoset.stax.factory.StAXOutputFactory;

import java.util.Scanner;

public class hj_08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) { // 注意 while 处理多个 case
            int index = Integer.parseInt(in.nextLine());
            int[] nums = new int[index];

            for(int i=0; i <index ; i++){
                String str = in.nextLine();
                int a = Integer.parseInt(str.split(" ")[0]);
                int b = Integer.parseInt(str.split(" ")[1]);
                nums[a] += b;

            }
            for(int i=0; i<index; i++){
                if(nums[i] != 0){
                    System.out.println(i + " " + nums[i]);
                }
            }
        }
    }
}
