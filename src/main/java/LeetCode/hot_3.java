package LeetCode;

import java.util.*;

public class hot_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> tmp = new HashSet<>();
        int len = s.length();
        int rightkey = -1;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0)
                tmp.remove(s.charAt(i-1));

            while (rightkey+1 < len && !tmp.contains(s.charAt(rightkey+1))){
                tmp.add(s.charAt(rightkey+1));
                rightkey++;
            }
            result = Math.max(result,rightkey - i + 1);
        }
        return result;
    }
}
