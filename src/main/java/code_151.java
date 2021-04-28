import java.util.*;

public class code_151 {
//    给定一个字符串，逐个翻转字符串中的每个单词。

    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordlist = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordlist);
        return String.join(" ",wordlist);
    }

    public String reverseWords_1(String s){
        int left = 0;
        int right = s.length() -1;
        while (left <= right && s.charAt(left) == ' ')
            left ++;
        while (left <= right && s.charAt(right) == ' ')
            right --;
        
        Deque<String> ds = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (left <= right){
            char c = s.charAt(left);
            if (sb.length() != 0 && c == ' '){
               ds.offerFirst(sb.toString());
               sb.setLength(0);
            }
            else if (c != ' ')
                sb.append(c);
            left++;
        }
        ds.offerFirst(sb.toString());
        return String.join(" ",ds);
    }
}
