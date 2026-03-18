package classAssignments.week2.containerWithMostWater;

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]). Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

// Input Format

// First line is the number of vertical lines.
// Secound line is the array having height for each line.

// Constraints

// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104

// Output Format

// Return the maximum amount of water a container can store.

// Sample Input 0

// 2
// 1 1
// Sample Output 0

// 1

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
     * Complete the 'maxArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY height
     */

    public static int maxArea(int n, List<Integer> height) {
        int start = 0, end = height.size() - 1;
        int maxWater = 0;

        while (start < end) {
            int minm = Math.min(height.get(start), height.get(end));
            int water = minm * (end - start);
            maxWater = Math.max(water, maxWater);

            if (height.get(start) < height.get(end)) {
                start++;
            } else {
                end--;
            }
        }

        return maxWater;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> height = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.maxArea(n, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
