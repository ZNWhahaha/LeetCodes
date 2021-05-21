package LeetCode;

public class code_offer_05 {

//    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    
    public String replaceSpace(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (str[i] == ' '){
                sb.append("%20");
            }
            else
                sb.append(str[i]);
        }
        return new String(sb);
    }

    public String replaceSpace_1(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        int size = s.length();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                count += 1;
        }
        char[] chars_new = new char[chars.length + count*2];
        for (int i = chars_new.length-1,j = chars.length-1; i >= 0; i--,j--) {
            if (chars[j] == ' '){
                chars_new[i] = '0';
                chars_new[i-1] = '2';
                chars_new[i-2] = '%';
                i -= 2;
            }
            else
                chars_new[i] = chars[j];
        }
        return new String(chars_new);
    }
}
