package SwordFingerOffer;

import java.util.HashMap;
import java.util.Map;

public class offer_17 {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen)
            return "";
        int need_cnt = tlen;
        Map<Character, Integer> need_char_cnt = new HashMap<>();
        for (int i = 0; i < tlen; i ++)
        {
            char c = t.charAt(i);
            need_char_cnt.put(c, need_char_cnt.getOrDefault(c, 0) + 1);
        }
        int res_start = -1;
        int res_len = Integer.MAX_VALUE;

        int l = 0;
        for (int r = 0; r < slen; r++) {
            if (need_char_cnt.containsKey(s.charAt(r)))
            {
                if (need_char_cnt.get(s.charAt(r)) > 0)
                    need_cnt --;
                need_char_cnt.put(s.charAt(r), need_char_cnt.get(s.charAt(r)) - 1);
            }

            if (need_cnt == 0)
            {
                while (true)
                {
                    if (!need_char_cnt.containsKey(s.charAt(l)))
                        l ++;
                    else
                    {
                        if (need_char_cnt.get(s.charAt(l)) < 0)
                        {
                            need_char_cnt.put(s.charAt(l), need_char_cnt.get(s.charAt(l)) + 1);
                            l ++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }

                if (r - l + 1 < res_len)
                {
                    res_len = r - l + 1;
                    res_start = l;
                }
            }
        }
        if (res_start == -1)
            return "";
        return s.substring(res_start, res_start + res_len);
    }
}
