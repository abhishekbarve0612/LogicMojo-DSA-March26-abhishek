// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

// Input Format

// First line is the length of the array
// Second line is the elements of the array

// Constraints

// 1 <= arr.length <= 3 * 104
// -100 <= arr[i] <= 100
// arr is sorted in non-decreasing order.

// Output Format

// Return length of array after removing duplicates

// Sample Input 0

// 9
// 1 1 1 2 3 4 5 6 7 
// Sample Output 0

// 7


package classAssignments.week3.removeDuplicatesFromSortedArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int removeDuplicates(List<Integer> arr) {
        int slow = 0, fast = 0;

        while (fast < arr.size()) {
            while (fast < arr.size() && arr.get(slow) == arr.get(fast)) fast++;
            if (fast < arr.size()) {
                slow++;
                arr.set(slow, arr.get(fast));
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>(java.util.Arrays.asList(1, 1, 1, 2, 3, 4, 5, 6, 7));
        // int[] arr = new int[] { 1, 1, 1, 2, 3, 4, 5, 6, 7 };

        int result = removeDuplicates(arr);

        System.out.println(result);
    }

}
