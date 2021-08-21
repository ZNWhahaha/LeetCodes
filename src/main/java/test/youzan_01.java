package test;

public class youzan_01 {
    public static boolean isPalindrome (String s) {
        // write code here
        int len = s.length();
        if (len == 0)
            return true;

        s = s.toLowerCase();
        int left = 0;
        int right = len-1;
        while (left < right){
            while (left+1 < len &&!check(s.charAt(left)))
                left ++;
            while (right-1 > 0 && !check(s.charAt(right)))
                right --;
            if (s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }

    private static boolean check(char c){
        if ((c >= 'a' && c <= 'z'))
            return true;
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "^%^&%%^%%*&^%";
        System.out.println(isPalindrome(s));
    }
}
