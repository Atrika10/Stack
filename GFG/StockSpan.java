import java.util.*;
public class StockSpan {

    public static int[] calculateSpan(int price[], int n){
        Stack<Integer> s = new Stack<>();
        int span[] = new int[price.length];

        if (n == 0) {
            return span;
        }
        // span of first day
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < price.length; i++) {
            int currPrice = price[i];
            while (!s.isEmpty() && currPrice >= price[s.peek()]) { // untill it'll not empty & small or equal to the price of currPrice
                s.pop();
            }
            // doing pop operation if it is becomes empty?
            if (s.isEmpty()) {
                span[i] = i+1;
            }else{
                // I found my prevHigh
                int prevHigh = s.peek();
                span[i] = i - prevHigh; // currIdx - prevHigh 
            }
            s.push(i) ;  // at the end I'm pushing my idx
        }
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
        return span;
    }

    public static void main(String[] args) {
        int price[] = {100, 80, 60 ,70, 60, 75, 85};
        calculateSpan(price, price.length);

    }
    
}
