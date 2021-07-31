package test;

import java.util.ArrayList;

public class onepot_01 {

    ArrayList<ArrayList<String>> result_tmp;
    int result = 0;
    public int countMaxActivity (ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        int result = 0;
        for (int i = 0; i < timeSchedule.size(); i++) {
            String Astart = timeSchedule.get(i).get(0);
            String Aend = timeSchedule.get(i).get(1);
            int tmp = 0;
            for (int j = 0; j < timeSchedule.size(); j++) {
                String Bstart = timeSchedule.get(j).get(0);
                String Bend = timeSchedule.get(j).get(1);
                if (check(Astart,Bstart) == 3 && check(Aend,Bend) ==3)
                    continue;
                if (check(Bstart,Astart) == 2 && check(Bend,Astart) == 2)
                    tmp += 1;
                if (check(Bstart,Astart) == 1 && check(Bend,Astart) == 1)
                    tmp += 1;
            }
            result = Math.max(result,tmp);
        }
        return result;
    }

    public int check(String s1, String s2){
        String[] st1 = s1.split(":");
        String[] st2 = s2.split(":");
        int len = Math.min(st1.length,st2.length);
        for (int i = 0; i < len; i++) {
            if (Integer.parseInt(st1[i]) > Integer.parseInt(st2[i]))
                return 1;
            else if (Integer.parseInt(st1[i]) < Integer.parseInt(st2[i]))
                return 2;
        }
        return 3;
    }
    
}
