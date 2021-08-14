package test;

public class beike_02 {

    public String solve(String s, int k) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        for (int i = 0; i < 26 && k >0; ++i) {
            if ((mask & (1 << i)) == 0) {
                mask &= ~(1 << i);
                k -= 1;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((mask & (1 << (c - 'a'))) != 0) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
