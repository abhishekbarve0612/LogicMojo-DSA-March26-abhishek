/*
Problem Description
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words.

The returned string should only have a single space separating the words.

Do not include any extra spaces.

Input format
String s.

Output format
The function should return a string of the words in reverse order concatenated by a single space.

Sample Input 1
hello world

Sample Output 1
world hello

Explanation
The given words after being reversed gives:world hello

Your reversed string should not contain leading or trailing spaces.

Constraints
1 <= s.length <= 10^5

s contains English letters (upper-case and lower-case), digits, and spaces ' '.

There is at least one word in s.
 */

package selfPractice.basics.adHoc.reverseSentence;

public class Solution {

    public static String reverseSentence(String s) {
        StringBuilder sb = new StringBuilder();

        int slowPointer = s.length() - 1;
        int fastPointer = slowPointer;

        // to skip the empty spaces at the end
        while (fastPointer > -1 && s.charAt(fastPointer) == ' ') {
            fastPointer--;
        }
        slowPointer = fastPointer;

        while (fastPointer > -1) {
            while (fastPointer > -1 && s.charAt(fastPointer) != ' ') {
                fastPointer--;
            }

            if (fastPointer > -2 && slowPointer < s.length()) {
                sb.append(s, fastPointer + 1, slowPointer + 1);
                sb.append(" ");
            }

            while (fastPointer > -1 && s.charAt(fastPointer) == ' ') {
                fastPointer--;
            }

            slowPointer = fastPointer;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("hello world"));
        System.out.println(reverseSentence("  hello world  "));
        System.out.println(reverseSentence("my name is Abhishek!"));
    }

}

/**
 * 
 * Approach 1:
 * - Split the string by space, reverse the array, rejoin and return
 * 
 * Approach 2:
 * - Do a brute force with two pointers
 * - Keep on incrementing the second pointer until you find a space or end of
 * string
 * - Reverse the substring from first pointer to second pointer
 * - Increment the first pointer to second pointer + 1
 * - Repeat until the second pointer reaches the end of the string
 * - Reverse the entire string
 * - Return the reversed string
 * 
 * 
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 * 
 */