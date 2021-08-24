package SwordFingerOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class offer_15 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;
        int[] si = new int[26];
        int[] pi = new int[26];
        int l = 0;
        int r = p.length();
        for (int i = 0; i < p.length(); i++) {
            si[s.charAt(i) - 'a'] ++;
            pi[p.charAt(i) - 'a'] ++;
        }
        while (r < s.length()){
            if (Arrays.equals(si,pi))
                result.add(l);
            si[s.charAt(r++) - 'a']++;
            si[s.charAt(l++) - 'a']--;
        }
        if (Arrays.equals(si,pi))
            result.add(l);
        return result;
    }
}
