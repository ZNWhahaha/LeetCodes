public class code_541 {
    
//    给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//    如果剩余字符少于 k 个，则将剩余字符全部反转。
//    如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

    public String reverseStr(String s, int k) {
        char[] str =s.toCharArray();
        for (int i = 0; i < str.length; i+=k*2) {
            if (i+k < str.length){
                str = reverse(str,i,i+k-1);
                continue;
            }
            str = reverse(str,i,str.length-1);
        }
        return new String(str);
    }

    private char[] reverse(char[] a,int start,int end){
        int offset = (end - start + 1) / 2;
        for (int i = start, j = end; i <start + offset; i++,j--) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        return a;
    }
}
