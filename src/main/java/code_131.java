import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_131 {

//    给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//    回文串 是正着读和反着读都一样的字符串。
//    示例 1：
//    输入：s = "aab"
//    输出：[["a","a","b"],["aa","b"]]
//    示例 2：
//    输入：s = "a"
//    输出：[["a"]]

    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }

    List<List<String>> result = new ArrayList<List<String>>();
    Deque<String> path = new ArrayDeque<String>();

    public void backtracking(String s,int startIndex){
        if (startIndex >= s.length()){
            result.add(new ArrayList<String>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s.split(""),startIndex,i)){
                String str = s.substring(startIndex,i+1);
                path.addLast(str);
            }
            else
                continue;
            backtracking(s,i+1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String[] s,int start,int end){
        for (int i = start, j = end; i < j; i++, j--) {
            if (!s[i].equals(s[j]) ){
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args){
//
//        System.out.println(isPalindrome("aab".split(""),0,1));
//    }
}
