package test;

public class shopee_03 {
    public static String compressString(String param) {
        if (param.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        char[] tmp = param.toCharArray();
        int index = 1;
        sb.append(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] == tmp[i-1]){
                index += 1;
                continue;
            }

            if (index != 1){
                sb.append(index);
                index = 1;
                i--;
            }
            else
                sb.append(tmp[i]);
        }
        if (index != 1)
            sb.append(index);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.print(compressString(s));
    }
}
