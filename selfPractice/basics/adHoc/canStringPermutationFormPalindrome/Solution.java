// Given a string S which consists of both lowercase and uppercase alphabetical letters, you have to write a function to check if string S is a permutation of a palindrome or not. Note: Characters are case sensitive i.e. ‘a’ is not the same as ‘A’.

// Input format
// First line contains an integer representing the value of T, the number of test cases.

// In next T lines each line contains the string S.

// Output format
// For each test case, print "True"(without quotes) if it is a permutation of a palindrome and "False" otherwise.

// Constraints
// 1 <= T <= 10

// 1 <= length(S) <= 100000

// Sample Input 1
// 3

// nnaamm

// hello

// Aab

// Sample Output 1
// True

// False

// False

// Explanation 1
// nnaamm is a permutation of namman, which is a palindrome

// hello is not a permutation of any palindrome

// Aab is not a permutation of any palindrome

package selfPractice.basics.adHoc.canStringPermutationFormPalindrome;

import java.util.*;

public class Solution {
    public static boolean isPalindromePossible(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePossible("nnaamm"));
        System.out.println(isPalindromePossible("hello"));
        System.out.println(isPalindromePossible("Aab"));
    }
}

/**
 * 
 * hello
 * 
 * Approach1: Keep track of hashmap
 * keep adding and cancelling the char counts
 * 
 * at the end either all the characters should have count 0 or only one
 * character should have count 1
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Approach2: Use HashSet
 * 
 * Keep on adding the characters to the set
 * if the character is already present in the set, remove it
 * 
 * at the end either the set should be empty or it should have only one
 * character
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * What can we do to achieve O(1) SC?
 * Approach3: Sort the string and check for duplicates
 * - TC: O(n log n)
 * - SC: O(1)
 * 
 * Possible Approach4:
 * - Brute force: Generate all permutations and check if any is a palindrome TC:
 * O(n!) SC: O(1)
 * -
 * 
 * 
 */