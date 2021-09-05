package SwordFingerOffer;

public class offer_18 {
    public boolean isPalindrome(String s) {
        int sn = s.length();
        String ls = s.toLowerCase();

        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < sn; i ++)
        {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isLetter(c))
                ss.append(Character.toLowerCase(c));
        }

        int n = ss.length();
        int l = 0;
        int r = n - 1;
        while (l < r)
        {
            if (ss.charAt(l) != ss.charAt(r))
                return false;
            l ++;
            r --;
        }
        return true;
    }
}
