/*
Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.

 

Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
Example 3:

Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".
 

Constraints:

1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] and list2[i] consist of spaces ' ' and English letters.
All the strings of list1 are unique.
All the strings of list2 are unique.
There is at least a common string between list1 and list2.
*/

package selfPractice.hashing.minIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        for (int i = 0; i < list1.length; i++)
            m1.put(list1[i], i);

        int minm = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (m1.containsKey(list2[i])) {
                m2.put(list2[i], m1.get(list2[i]) + i);
                minm = Math.min(minm, m2.get(list2[i]));
            }
        }

        List<String> res = new ArrayList<>();

        for (Map.Entry<String, Integer> e : m2.entrySet()) {
            if (e.getValue() == minm)
                res.add(e.getKey());
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
        System.out.println(Arrays.toString(s.findRestaurant(list1, list2))); // ["Shogun"]

        list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        list2 = new String[] { "KFC", "Shogun", "Burger King" };
        System.out.println(Arrays.toString(s.findRestaurant(list1, list2))); // ["Shogun"]

        list1 = new String[] { "happy", "sad", "good" };
        list2 = new String[] { "sad", "happy", "good" };
        System.out.println(Arrays.toString(s.findRestaurant(list1, list2))); // ["sad","happy"]
    }
}
