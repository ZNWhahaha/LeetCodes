package SwordFingerOffer;

public class offer_05 {
    public int maxProduct(String[] words) {
        int n = words.length;
        if(n<=2) return 0;
        int[] maskArr = new int[n];
        for(int i=0;i<n;i++) {
            maskArr[i]=CalcMask(words[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if((maskArr[i]&maskArr[j])==0) {
                    ans=Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }

    private int CalcMask(String s) {
        int mask = 0;
        char[] tmp = s.toCharArray();
        for(char c : tmp) {
            int idx = c-'a';
            mask|=(1<<idx);
        }
        return mask;
    }
}
