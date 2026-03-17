// Given a list containing future prediction of share prices, find the maximum profit earned
// by buying and selling shares any number of times with the constraint, a new transaction
// can only start after the previous transaction is complete, i.e., we can only hold at most
// one share at a time

// Stock Prices: {1, 5, 2, 3, 7, 6, 4, 5}
// Total profit earned is 10
// Buy on day 1 and sell on day 2
// Buy on day 3 and sell on day 5
// Buy on day 7 and sell on day 8

class Solution {
        public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;

        int boughtAt = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                currentProfit = Math.max(
                    prices[i] - prices[boughtAt], currentProfit);
            } else {
                // book the profit
                maxProfit += currentProfit;
                currentProfit = 0;
                boughtAt = i;
            }
        }
        if (currentProfit != 0) maxProfit += currentProfit;

        return maxProfit;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {1, 5, 2, 3, 7, 6, 4, 5};
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit); // Output: 10     
    }
}