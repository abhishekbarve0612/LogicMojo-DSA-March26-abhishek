// Given an array prices[] of length N, representing the prices of the stocks on different
// days, the task is to find the maximum profit possible for buying and selling the stocks on
// different days using transactions where at most one transaction is allowed.
// Note: Stock must be bought before being sold.
// Input: prices[] = {7, 1, 5, 3, 6, 4]
// Output: 5
// Explanation:
// The lowest price of the stock is on the 2nd day, i.e. price = 1. Starting from the 2nd day,
// the highest price of the stock is witnessed on the 5th day, i.e. price = 6.
// Therefore, maximum possible profit = 6 – 1 = 5

class Solution {
    public int getMaxProfit(int[] prices) {
        int boughtAt = prices[0], maxProfit = 0;

        for (int price: prices) {
            if (price < boughtAt) {
                boughtAt = price;
            } else if (price - boughtAt > maxProfit) {
                maxProfit = price - boughtAt;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.getMaxProfit(prices);
        System.out.println(maxProfit); // Output: 5
     }
}