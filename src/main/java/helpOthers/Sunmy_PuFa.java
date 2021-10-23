package helpOthers;

public class Sunmy_PuFa {
    private static int[] Run(int[] nums1, int[] nums2){
        int[] result;
        int index1 = nums1.length-1;
        int index2 = nums2.length-1;
        int num1 = 0;
        int num2 = 0;
        for (int i = index1; i >= 0 ; i--) {
            num1 += nums1[i]*Math.pow(10,index1-i);
        }
        for (int i = index2; i >= 0 ; i--) {
            num2 += nums2[i]*Math.pow(10,index2-i);
        }
        int re = num1+num2;
        char[] chs = String.valueOf(re).toCharArray();
        result = new int[chs.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = chs[i]-'0';
        }
        return result;
    }
    public static void main(String[] args) {
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        int[] re = Run(nums1,nums2);
        for (int i : re){
            System.out.print(i);
        }
    }

}
