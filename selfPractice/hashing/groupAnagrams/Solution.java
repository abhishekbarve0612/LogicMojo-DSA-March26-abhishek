/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

*/
package selfPractice.hashing.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charr = str.toCharArray();
            Arrays.sort(charr);
            String sorted = new String(charr);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                map.put(sorted, new ArrayList<>(List.of(str)));
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = s.groupAnagrams(strs);
        System.out.println(result); // [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
    }
}
