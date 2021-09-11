package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class wuba58_02 {
    public int[] find (int[] arg) {
        // write code here
        HashMap<Integer,Integer> check = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i : arg){
            check.put(i,check.getOrDefault(i,0)+1);
        }
        for (int i : check.keySet()){
            if (check.get(i) == 1)
                result.add(i);
        }
        int[] res = new int[result.size()];
        int index = 0;
        for (int i = 0; i < arg.length; i++) {
            if (result.contains(arg[i])){
                res[index] = arg[i];
                index++;
            }
        }
        return res;
    }
}
