package LeetCode;

public class code_1710 {
    public int majorityElement(int[] nums) {
        int size = nums.length;
        int cnt = 0 ;
        int major = 0;
        for(int n : nums){
            if(cnt == 0){
                major = n;
                cnt ++;
            }
            else{
                if(major == n) cnt ++;
                else cnt --;
            }
        }
        int C = 0;
        for(int i = 0; i < size; i++) {
            if(nums[i] == major) C++;
        }
        if(C <= size / 2) major = -1;
        return major;
    }
}
