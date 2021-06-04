package LeetCode;

//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

public class code_75 {
    public void sortColors(int[] nums) {
        if (nums.length <= 1)
            return;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    //双指针法
    public void sortColors_1(int[] nums) {
        int len = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1){
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                ++p1;
            }
            else if (nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if (p1 > p0) {
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}
