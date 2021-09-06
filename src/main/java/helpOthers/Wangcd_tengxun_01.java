package helpOthers;

import java.util.Scanner;

public class Wangcd_tengxun_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] tmp = in.nextLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int l = Integer.parseInt(tmp[1]);
        int r = Integer.parseInt(tmp[2]);
        StringBuilder sb = new StringBuilder();
        sb.append(n+"#");
        while (check(sb.toString())){
            int pre = 0;
            StringBuilder t = new StringBuilder();
            String[] aa = sb.toString().split("#");
            for (int i = 0; i < aa.length; i++) {
                int x = Integer.parseInt(aa[i]);
                  if (x == 1 || x == 0){
                      t.append(x+"#");
                      continue;
                  }

                  t.append(broth(x));
            }
            sb = t;
        }
        System.out.println(shu1(sb.toString(),l-1,r-1));
    }

    private static int shu1(String nums, int l, int r){
        nums = nums.replaceAll("#","");
        int result = 0;
        int len = Math.min(nums.length()-1,r);
        for (int i = l; i <= len ; i++) {
            if (nums.charAt(i) == '1')
                result ++;
        }
        return result;
    }
    private static boolean check(String num){
        String[] tmp = num.split("#");

        for (int i = 0; i < tmp.length; i++) {
            if (!tmp[i].equals("1"))
                if (!tmp[i].equals("0"))
                    return true;
        }
        return false;
    }
    private static String broth(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(num / 2+"#");
        sb.append(num % 2+"#");
        sb.append(num / 2+"#");
        return sb.toString();
    }
}
