/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true

 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

package selfPractice.hashing.containsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = { 1, 2, 3, 1 }; // true
        int[] nums2 = { 1, 2, 3, 4 }; // false
        int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }; // true

        System.out.println(s.containsDuplicate(nums1));
        System.out.println(s.containsDuplicate(nums2));
        System.out.println(s.containsDuplicate(nums3));
    }
}
