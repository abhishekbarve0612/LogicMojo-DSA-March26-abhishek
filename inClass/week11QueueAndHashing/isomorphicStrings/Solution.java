/**
 * 
 * Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "f11", t = "b23"

Output: false

Explanation:

The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

Example 3:

Input: s = "paper", t = "title"

Output: true

 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */
package inClass.week11QueueAndHashing.isomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(t.charAt(i));
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return set.size() == map.size();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "egg";
        String t1 = "add";

        String s2 = "f11";
        String t2 = "b23";

        String s3 = "paper";
        String t3 = "title";

        System.out.println(s.isIsomorphic(s1, t1)); // true
        System.out.println(s.isIsomorphic(s2, t2)); // false
        System.out.println(s.isIsomorphic(s3, t3)); // true
    }
}
