package SwordFingerOffer;

public class offer_19 {
    public boolean validPalindrome(String s) {
        int len = s.length();
        int l = 0;
        int r = len-1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r))
                return check(s, l+1, r) || check(s, l, r-1);
            l++;
            r--;
        }
        return true;
    }

    private boolean check(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
