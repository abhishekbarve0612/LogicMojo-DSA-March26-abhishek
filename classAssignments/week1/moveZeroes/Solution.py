# Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

# Note that you must do this in-place without making a copy of the array.

# Input Format

# First line is length of the array Next line is the elements of the array

# Constraints

# 1 <= arr.length <= 104
# 0 <= arr[i] <= 231 - 1

# Output Format

# Return the array as per requirement

# Sample Input 0

# 6
# 1 2 0 0 3 4
# Sample Output 0

# 1 2 3 4 0 0

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'move_func' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY arr
#

def move_func(n, arr):
    first = 0
    for i in range(len(arr)):
        while first < len(arr) and arr[first] == 0:
            first += 1
        if arr[i] == 0 and first < len(arr):
            arr[i], arr[first] = arr[first], arr[i]
        first += 1
        
    return arr
            

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = move_func(n, arr)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
