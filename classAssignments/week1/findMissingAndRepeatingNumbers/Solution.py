# // You are given a read-only array of N integers with values also in the range [1,N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

# // Input Format

# // First line is the length of the array - n
# // Second line contains n integer that is elements of the array

# // Constraints

# // 1 <= n <= 105
# // 1 <= arr[i] <= n

# // Output Format

# // Print array of integers containing repeating and missing number respectively

# // Sample Input 0

# // 3
# // 3 1 3
# // Sample Output 0

# // 3 2
# // Explanation 0

# // A = 3 , B = 2 Since 3 is appearing twice and 2 is missing
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'find_missing' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY arr as parameter.
#
def find_missing(arr):
    arr.sort()

    missing, duplicate = 0, 0
    for i in range(1, len(arr)):
        if i not in arr and not missing:
            missing = i
        if arr[i - 1] == arr[i] and not duplicate:
            duplicate = arr[i]
        if duplicate and missing:
            return [duplicate, missing]
    return [duplicate, arr[-1] + 1]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = find_missing(arr)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
