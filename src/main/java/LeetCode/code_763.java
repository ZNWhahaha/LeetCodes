package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class code_763 {

//    字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//    示例：
//    输入：S = "ababcbacadefegdehijhklij"
//    输出：[9,7,8]
//    解释：
//    划分结果为 "ababcbaca", "defegde", "hijhklij"。
//    每个字母最多出现在一个片段中。
//    像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

    public List<Integer> partitionLabels(String S) {
        char[] chars = S.toCharArray();
        List<Integer> results = new LinkedList<Integer>();
        int end = 0;
        int start = 0;
        for (int i = start; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j])
                    end = Math.max(j,end);
            }
            if (i == end){
                results.add(end - start + 1);
                start = end + 1;
                end = 0;
            }
        }
        return results;
    }

    public List<Integer> partitionLabels_1(String S) {
        char[] chars = S.toCharArray();
        List<Integer> results = new LinkedList<Integer>();
        int[] char_index = new int[27];
        for (int i = 0; i < chars.length; i++) {
            char_index[chars[i] - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end,char_index[chars[i] - 'a']);
            if (i == end){
                results.add(end - start + 1);
                start = end + 1;
            }
        }
        return results;
    }
}
