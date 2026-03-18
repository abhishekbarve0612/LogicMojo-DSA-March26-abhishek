// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Input Format

// Integer N. Integer array of length N.

// Constraints

// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104
// Output Format

// Integer.

// Sample Input 0

// 6
// 7 1 5 3 6 4
// Sample Output 0

// 5
// Explanation 0

// Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'best_time_to_buy_and_sell_stock' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static int best_time_to_buy_and_sell_stock(int n, List<Integer> arr) {
        int profit = 0;
        int boughtAt = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > boughtAt) {
                profit = Math.max(arr.get(i) - boughtAt, profit);
            } else {
                boughtAt = arr.get(i);
            }
        }

        return profit;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.best_time_to_buy_and_sell_stock(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

