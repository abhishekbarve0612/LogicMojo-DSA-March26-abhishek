/**
 * Problem Description
Given two strings s and t, write a function to determine if t is an anagram of s.

Note: You may assume the string contains only lowercase alphabets.

Note:-
There's a test case where both the strings are empty but the js compiler is treating one as empty and other as undefined. So, update the readline function accordingly.

Input format
You will be given two strings in two separate lines.

Output format
Print "true" if both the strings are anagram otherwise “false”.

Constraints
Length of string <= 100000

Sample Input 1
anagram

nagaram

Sample Output 1
true

Sample Input 2
rat

car

Sample Output 2
false
 */

package selfPractice.basics.adHoc.areTwoStringsAnagram;

import java.util.HashMap;

public class Solution {
    public static boolean validAnagram(String s, String t) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) - 1);
                if (frequencyMap.get(c) == 0) {
                    frequencyMap.remove(c);
                }
            } else {
                return false;
            }
        }

        return frequencyMap.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validAnagram("anagram", "nagaram"));
        System.out.println(validAnagram("rat", "car"));
    }
}

/**
 * Approach 1:
 * - Sort both the strings
 * - Match char by char, if matched till end, they are anagrams
 * 
 * Approach 2:
 * - Use Frequency Hashmap
 * - Trace through first string to keep frequency in hashmap
 * - Start with second string, if the iterating character is not found in
 * hashmap, return false
 * - If found, decrement it, if it becomes 0, delete it
 * 
 * - If the map is empty, return true, else false
 */