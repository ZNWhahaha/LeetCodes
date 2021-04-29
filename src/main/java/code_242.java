public class code_242 {

//    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

    public static boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("rat","car");
    }
}

