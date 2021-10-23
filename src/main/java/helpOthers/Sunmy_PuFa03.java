package helpOthers;

public class Sunmy_PuFa03 {
    public static int solution(int[] nums, int[] result){
        int len_result;
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=0;j<nums.length-1-i;j++)
            {
                if(nums[j]>nums[j+1])
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        int maxnums = nums[nums.length-1];
        len_result = 0;
        for (int i = 0; i < maxnums; i++) {
            int flag = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    flag = 1;
            }
            if (flag == 0){
                len_result ++;
            }
        }
        int indexre = 0;
        for (int i = 1; i < maxnums; i++) {
            int flag = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    flag = 1;
            }
            if (flag == 0){
                result[indexre] = i;
                indexre ++;
            }
        }
        return len_result;
    }

    public static void main(String[] args) {
        int[] num = {1,2,8,4,6,6,7,8};
        int[] result = new int[num.length];
        solution(num,result);
        for (int i : result){
            System.out.print(i);
        }
    }
}
