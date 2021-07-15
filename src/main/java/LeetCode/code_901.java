package LeetCode;

//编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
//        今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
//        例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。


import java.util.Deque;
import java.util.LinkedList;

public class code_901 {

    private  Deque<Integer> priceStack;
    private  Deque<Integer> widthStack;

    public code_901() {
        this.priceStack = new LinkedList<>();
        this.widthStack = new LinkedList<>();
    }

    public int next(int price) {
        int width = 1;
        while (!priceStack.isEmpty() && priceStack.peek() <= price){
            priceStack.pop();
            width += widthStack.pop();
        }
        priceStack.push(price);
        widthStack.push(width);
        return width;
    }
}
