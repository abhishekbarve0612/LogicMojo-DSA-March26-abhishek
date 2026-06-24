/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
*/
package selfPractice.hashing.jewelsAndStones;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> s = new HashSet<>();

        for (char c : jewels.toCharArray())
            s.add(c);

        int count = 0;

        for (char stone : stones.toCharArray()) {
            if (s.contains(stone))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(s.numJewelsInStones(jewels, stones)); // 3

        jewels = "z";
        stones = "ZZ";
        System.out.println(s.numJewelsInStones(jewels, stones)); // 0
    }

}
