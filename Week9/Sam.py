# !/bin/python3

import math
import os
import random
import re
import sys


def substrings(n):
    difference = int(n[0])
    previous = int(n[0])
    for i, curr_char in enumerate(n[1:]):
        current = previous + (difference * 10) + ((i + 2) * int(curr_char))
        difference = current - previous
        previous = current

    return previous % (pow(10, 9) + 7)


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = input()

    result = substrings(n)

    fptr.write(str(result) + '\n')

    fptr.close()
