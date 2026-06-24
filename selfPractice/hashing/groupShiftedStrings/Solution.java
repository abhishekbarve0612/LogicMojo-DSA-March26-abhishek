/*
Perform the following shift operations on a string:

Right shift: Replace every letter with the successive letter of the English alphabet, where 'z' is replaced by 'a'. For example, "abc" can be right-shifted to "bcd" or "xyz" can be right-shifted to "yza".
Left shift: Replace every letter with the preceding letter of the English alphabet, where 'a' is replaced by 'z'. For example, "bcd" can be left-shifted to "abc" or "yza" can be left-shifted to "xyz".
We can keep shifting the string in both directions to form an endless shifting sequence.

For example, shift "abc" to form the sequence: ... <-> "abc" <-> "bcd" <-> ... <-> "xyz" <-> "yza" <-> .... <-> "zab" <-> "abc" <-> ...
You are given an array of strings strings, group together all strings[i] that belong to the same shifting sequence. You may return the answer in any order.

 

Example 1:

Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]

Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]

Example 2:

Input: strings = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strings.length <= 200
1 <= strings[i].length <= 50
strings[i] consists of lowercase English letters.
*/
package selfPractice.hashing.groupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = getKey(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                map.put(key, new ArrayList<>(List.of(s)));
            }
        }

        return new ArrayList<>(map.values());
    }

    public String getKey(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            sb.append(String.valueOf((str.charAt(i + 1) - str.charAt(i) + 26) % 26) + ',');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strings = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
        List<List<String>> result = s.groupStrings(strings);
        System.out.println(result);
    }
}
