package LeetCode;

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//        假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
//        你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。

public class code_287 {

    // 快慢指针
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // 二分法
//    二分查找的思路是先猜一个数（有效范围 [left..right] 里位于中间的数 mid），然后统计原始数组中 小于等于 mid 的元素的个数 cnt：
//    如果 cnt 严格大于 mid。根据抽屉原理，重复元素就在区间 [left..mid] 里；
//    否则，重复元素就在区间 [mid + 1..right] 里。
    public int findDuplicate_1(int[] nums){
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
