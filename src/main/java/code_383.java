import java.util.HashMap;

public class code_383 {

//    给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
//
//            (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < 0)
            return false;
        HashMap<Character,Integer> hash = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            hash.put(magazine.charAt(i),hash.getOrDefault(magazine.charAt(i),0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (hash.containsKey(ransomNote.charAt(i)) == false)
                return false;
            if (hash.containsKey(ransomNote.charAt(i))){
                if (hash.get(ransomNote.charAt(i)) == 0)
                    return false;
                hash.put(ransomNote.charAt(i),hash.get(ransomNote.charAt(i))-1);
            }
        }
        return true;
    }
    //二维数组
    public static boolean canConstruct_1(String ransomNote, String magazine){
        int[][] chars = new int[2][26];
        if (magazine.length() < ransomNote.length())
            return false;
        for (int i = 0; i < magazine.length(); i++) {
            chars[0][magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            chars[1][ransomNote.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[0][i] < chars[1][i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        canConstruct("aa","ab");
    }
}
