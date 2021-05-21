package LeetCode;

public class code_997 {
    private static int count;

    public int[] sortedSquares(int[] nums) {
        int[] newnumber = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newnumber[i] = (int) Math.pow(nums[i],2);
        }
        QuickSort(newnumber,0,newnumber.length-1);
        return newnumber;
    }

    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(num[j]>=key && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(num[i]<=key && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        count++;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
    }

}
