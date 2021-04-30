import java.util.HashMap;

public class code_454 {

//    给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
//
//    为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int a : nums1){
            for (int b : nums2){
                hash.put(a+b,hash.getOrDefault(a+b,0)+1);
            }
        }
        int count = 0;
        for (int c : nums3){
            for (int d : nums4){
                if (hash.containsKey(-c - d)){
                    count += hash.get(-c -d);
                }
            }
        }
        return count;
    }
}
