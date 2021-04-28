public class code_28 {

//    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
    //超出时限
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j-1];
            if (haystack.charAt(i) == needle.charAt(j))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }
    //超出时限
    private int[] getNext(String needle){
        int[] next = new int[needle.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j))
                j = next[j-1];
            if (needle.charAt(i) == needle.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }

}
