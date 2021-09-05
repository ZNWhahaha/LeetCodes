package SwordFingerOffer;

public class offer_76 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        buildMaxHeap(nums,len);
        int result = 0;
        for (int i = len-1; i > nums.length - k - 1 ; i--) {
            result = nums[i];
            swap(nums,0,i);
            len--;
            heapify(nums,0,len);
        }
        return result;
    }

    private void buildMaxHeap(int[] nums,int len){
        for (int i = (int)Math.floor(len / 2); i >= 0 ; i--) {
            heapify(nums,i,len);
        }
    }

    private void heapify(int[] nums, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && nums[left] > nums[largest])
            largest = left;
        if (right < len && nums[right] > nums[largest])
            largest = right;

        if (largest != i){
            swap(nums,i,largest);
            heapify(nums,largest,len);
        }
    }

    private void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
