public class code_459 {

    //    给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 0)
            return false;
        int[] next = getNext(s);
        int len = s.length();
        if (next[len-1] != 0 && len % (len - next[len - 1]) == 0)
            return true;
        return false;
    }

    private int[] getNext(String s){
        int[] next = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = next[j-1];
            if (s.charAt(i) == s.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }
}

