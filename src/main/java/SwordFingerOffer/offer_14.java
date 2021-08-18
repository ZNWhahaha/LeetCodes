package SwordFingerOffer;

import java.util.HashMap;
import java.util.Map;

public class offer_14 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2)
            return false;
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a'] ++;
            count[s2.charAt(i) - 'a'] --;
        }
        if (checkAllzore(count))
            return true;
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;
            if (checkAllzore(count)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAllzore(int[] nums){
        for (int n : nums){
            if (n != 0)
                return false;
        }
        return true;
    }
}
