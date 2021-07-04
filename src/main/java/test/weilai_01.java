package test;

import java.util.HashMap;

public class weilai_01 {
    public String skipsame (String old) {
        // write code here
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < old.length(); i++) {
            char tmp = old.charAt(i);
            if (map.containsKey(tmp))
                continue;
            map.put(tmp,1);
            sb.append(tmp);
        }
        return sb.toString();
    }
}
