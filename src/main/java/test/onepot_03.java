package test;

public class onepot_03 {

    public static int[] max_version (String[][] version_list) {

        int[] result = new int[version_list.length];
        for (int i = 0; i < version_list.length; i++) {
            String s1 = version_list[i][0];
            String s2 = version_list[i][1];
            if (s1.length() == 0 && s2.length() != 0)
                result[i] = 2;
            else if (s2.length() == 0)
                result[i] = 1;
            else
                result[i] = check(s1,s2);
        }
        return result;
    }

    public static int check(String s1, String s2){
        String[] st1 = s1.split("\\.");
        String[] st2 = s2.split("\\.");
        if (st1.length > 4)
            return 2;
        if (st2.length > 4)
            return 1;
        int len = Math.min(st1.length,st2.length);
        for (int i = 0; i < len; i++) {
            if (Integer.parseInt(st1[i]) >= Integer.parseInt(st2[i]))
                return 1;
            else
                return 2;
        }
        return len == st1.length ? 2 : 1;
    }
    
    public static void main(String[] args) {
        String[][] tmp = new String[][]{{"0.1.0", ""},{"2.1.13", "1.20.0"},{"2.1.0", "2.1.0"}};
        int[] re = max_version(tmp);
        for (int i : re){
            System.out.println(i);
        }
    }
}
