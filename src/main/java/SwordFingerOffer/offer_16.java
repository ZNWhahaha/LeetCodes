package SwordFingerOffer;

import java.util.HashMap;
import java.util.HashSet;

public class offer_16 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 0)
            return 0;
        int left = 0;
        int right = 0;
        int result = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for (; right < len; right++) {
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);

            while (map.get(c) > 1){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left ++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
