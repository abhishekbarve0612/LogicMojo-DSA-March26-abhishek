// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

// Input Format

// First line is the length of the array
// Next line is the elements of the array

// Constraints

// 1 <= arr.length <= 105
// 0 <= arr[i] <= 105

// Output Format

// Return the single element

// Sample Input 0

// 7
// 3 3 7 7 10 11 11
// Sample Output 0

// 10


package classAssignments.week3.singleElementInSorted;

import java.util.List;

public class Solution {
    public static int singlelement(int n, List<Integer> arr) {

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new java.util.ArrayList<>(java.util.Arrays.asList(3, 3, 7, 7, 10, 11, 11));
        int n = arr.size();

        int result = singlelement(n, arr);

        System.out.println(result);
    }
}
