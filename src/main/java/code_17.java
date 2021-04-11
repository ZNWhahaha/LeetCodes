import java.util.*;

public class code_17 {

//    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
//    示例 1：
//    输入：digits = "23"
//    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    示例 2：
//    输入：digits = ""
//    输出：[]

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        backtracking(digits,0,new StringBuffer());
        return result;
        
    }
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    List<String> result = new ArrayList<String>();
    public void backtracking(String digits,int index, StringBuffer combination){
        if (index == digits.length()){
            result.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i));
            backtracking(digits,index+1,combination);
            combination.deleteCharAt(index);
        }
    }


}
