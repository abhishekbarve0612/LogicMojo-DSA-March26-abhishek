# Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

# Input Format

# Integer N.
# Integer Array of size N.

# Constraints

# 1 <= N <= 10^6
# 0 <= A[i] <= 2
# Output Format

# Integer Array of size N.

# Sample Input 0

# 5
# 0 1 2 1 2
# Sample Output 0

# 0 1 1 2 2
# Explanation 0

# 0s 1s and 2s are segregated into ascending order.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'sort_an_array' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY arr
#


def sort_an_array(n, arr):
    first, last = 0, len(arr) - 1
        
    counter = 0
        
    while counter <= last:
        if arr[counter] == 2:
            arr[counter], arr[last] = arr[last], arr[counter]
            last -= 1
        elif arr[counter] == 0:
            arr[counter], arr[first] = arr[first], arr[counter]
            first += 1
            counter += 1
        else:
            counter += 1
#     for i in range(len(arr)):
#         if arr[i] == 2 and i < last:
#             arr[i], arr[last] = arr[last], arr[i]
#             last -= 1
#         elif arr[i] == 0 and i > first:
#             arr[i], arr[first] = arr[first], arr[i]
#             first += 1
            
#         if first > last:
#             return arr
            
    return arr

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = sort_an_array(n, arr)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
