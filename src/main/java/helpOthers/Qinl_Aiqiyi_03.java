package helpOthers;

import java.util.Scanner;

public class Qinl_Aiqiyi_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] tmp = in.nextLine().split("],");
        String[][] tmp1 = new String[tmp.length][2];
        for (int i = 0; i < tmp1.length; i++) {
            tmp1[i] = tmp[i].split(",");
            int h = 1;
        }
        int[][] sets = new int[tmp.length][2];
        for (int i = 0; i < sets.length; i++) {
            for (int j = 0; j < 2; j++) {
                String nums = "";
                for (int k = 0; k < tmp1[i][j].length(); k++) {
                    char c = tmp1[i][j].charAt(k);
                    if(c>=48 && c<=57)
                        nums += c;
                }
                sets[i][j] = Integer.parseInt(nums);
            }
        }
        System.out.println(sets);
        
    }
}
