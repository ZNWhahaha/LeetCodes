package SwordFingerOffer;

import java.sql.PreparedStatement;

public class offer_02 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0){
            int tmp_a = i >= 0 ? a.charAt(i--)-'0' : 0;
            int tmp_b = j >= 0 ? b.charAt(j--)-'0' : 0;
            int sum = tmp_a + tmp_b + carry;
            if (sum > 1)
                carry = 1;
            else
                carry = 0;
            sb.append(sum > 1 ? sum - 2 : sum);
        }
        if (carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
}
