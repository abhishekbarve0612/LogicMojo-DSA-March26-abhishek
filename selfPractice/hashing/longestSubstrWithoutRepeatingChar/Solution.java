/*
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
package selfPractice.hashing.longestSubstrWithoutRepeatingChar;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int first = 0, second = 0;
        Set<Character> window = new HashSet<>();

        int maxLen = 0;

        while (second < s.length()) {
            while (second < s.length() && !window.contains(s.charAt(second))) {
                window.add(s.charAt(second));
                second++;
            }
            maxLen = Math.max(maxLen, second - first);

            while (second < s.length() && window.contains(s.charAt(second))) {
                window.remove(s.charAt(first++));
            }
        }

        return Math.max(maxLen, second - first);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(s.lengthOfLongestSubstring(s1)); // 3
        System.out.println(s.lengthOfLongestSubstring(s2)); // 1
        System.out.println(s.lengthOfLongestSubstring(s3)); // 3
    }
}
