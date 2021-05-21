package LeetCode;

public class code_offer_58_2 {

//    字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        chars = reverse(chars,0,n-1);
        chars = reverse(chars,n,chars.length);
        chars = reverse(chars,0,chars.length);
        return new String(chars);
    }

    private char[] reverse(char[] a,int start,int end){
        int offset = (end - start + 1)/2;
        for (int i = start,j=end; i < start + offset; i++,j--) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        return a;
    }
}
