/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
 

Constraints:

1 <= n <= 231 - 1
*/
package selfPractice.hashing.happyNumbers;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();

        int temp = n;

        while (!s.contains(temp)) {
            s.add(temp);
            temp = sumOfSqDig(temp);
            System.out.println(temp);

            if (temp == 1)
                return true;
        }

        return false;
    }

    public int sumOfSqDig(int num) {
        int temp = num;
        int sum = 0;

        while (temp > 0) {
            sum += (temp % 10) * (temp % 10);
            temp /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 19; // true
        int n1 = 2; // false
        System.out.println(s.isHappy(n));
        System.out.println(s.isHappy(n1));
    }
}
