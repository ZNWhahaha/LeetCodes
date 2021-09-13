package helpOthers;

import java.util.PriorityQueue;
import java.util.Random;

public class Wangcd_bilibili_01 {
    static int k;
    public int[] smallestK(int[] arr, int _k) {
        k = _k;
        int n = arr.length;
        int[] ans = new int[k];
        if (k == 0) return ans;
        qsort(arr, 0, n - 1);
        for (int i = 0; i < k; i++) ans[i] = arr[i];
        return ans;
    }
    static void qsort(int[] arr, int l, int r) {
        if (l >= r) return ;
        int i = l, j = r;
        int ridx = new Random().nextInt(r - l + 1) + l;
        swap(arr, ridx, l);
        int x = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= x) j--;
            while (i < j && arr[i] <= x) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 集中答疑：因为题解是使用「基准点左侧」来进行描述（不包含基准点的意思），所以这里用的 k（写成 k - 1 也可以滴
        if (i > k) qsort(arr, l, i - 1);
        if (i < k) qsort(arr, i + 1, r);
    }
    static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static int[] smallestK_1(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        for (int i : arr) q.add(i);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = q.poll();
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,7,6,1,5,2};
        int[] b = smallestK_1(a,2);
        for (int i : b)
            System.out.println(i);
    }
}
