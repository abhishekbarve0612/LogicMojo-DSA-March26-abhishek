package classAssignments.week2.minMaxPairSumInArray;

// The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.

// - For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.

// Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:

// - Each element of nums is in exactly one pair, and - The maximum pair sum is minimized.

// Return the minimized maximum pair sum after optimally pairing up the elements.

// Input Format

// Integer n. Integer array of length n.

// Constraints

// n == nums.length
// 2 <= n <= 105
// n is even.
// 1 <= nums[i] <= 105
// Output Format

// Integer

// Sample Input 0

// 4
// 3 5 2 3
// Sample Output 0

// 7
// Explanation 0

// The elements can be paired up into pairs (3,3) and (5,2). The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
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
     * Complete the 'minPairSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static int minPairSum(int n, List<Integer> arr) {
        Collections.sort(arr);
        int minimizedMaxPairSum = Integer.MIN_VALUE;

        int start = 0, end = arr.size() - 1;

        while (start < end) {
            minimizedMaxPairSum = Math.max(minimizedMaxPairSum, arr.get(end) + arr.get(start));
            start++;
            end--;
        }

        return minimizedMaxPairSum;
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

        int result = Result.minPairSum(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
