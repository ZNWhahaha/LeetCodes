package SwordFingerOffer;

public class offer_03 {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = check(i);
        }
        return result;
    }

    private int check(int num){
        String tmp = Integer.toBinaryString(num);
        int result = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '1')
                result += 1;
        }
        return result;
    }

    public int[] countBits_1(int n) {
        int ans[] = new int[n+1];
        for(int i = 0;i <= n;i++) {
            if((i&1)==0){ //偶数
                ans[i] = ans[i>>1];
            }else{ //奇数
                ans[i] = ans[i-1]+1;
            }
        }
        return ans;
    }

}
