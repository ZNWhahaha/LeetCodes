package LeetCode;

//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//        例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//        提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class code_739 {
    //暴力解法
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int time = 0;
            for (int j = i+1; j < n; j++) {
                time += 1;
                if (temperatures[i] < temperatures[j]){
                    result[i] = time;
                    break;
                }
                else if (j == n-1)
                    result[i] = 0;
            }
        }
        return result;
    }
    
    //单调栈
    public int[] dailyTemperatures_1(int[] temperatures){
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int t = stack.pop();
                result[t] = i - t;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures_2(int[] temperatures){
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
