import java.util.HashSet;
import java.util.Set;

public class code_202 {
//    编写一个算法来判断一个数 n 是不是快乐数。
//
//            「快乐数」定义为：
//
//    对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//    如果 可以变为  1，那么这个数就是快乐数。
//    如果 n 是快乐数就返回 true ；不是，则返回 false 。

    //哈希表法
    public boolean isHappy_1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    //快慢指针法
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSum(n);
        while (slow != fast && fast != 1){
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return fast == 1;
    }

    private int getSum(int num){
        int sum = 0;
        while (num > 0){
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
