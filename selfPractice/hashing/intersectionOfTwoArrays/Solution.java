/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
*/

package selfPractice.hashing.intersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1)
            set1.add(num);
        for (int num : nums2)
            set2.add(num);

        set1.retainAll(set2);

        Iterator<Integer> iter = set1.iterator();

        int[] result = new int[set1.size()];

        int idx = 0;

        while (iter.hasNext()) {
            result[idx++] = iter.next();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        int[] intersection = s.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection)); // [2]
    }
}
