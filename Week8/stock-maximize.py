#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'stockmax' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER_ARRAY prices as parameter.
#

def stockmax(prices):
    spent, shares, answer = 0, 0, 0

    while len(prices) > 1:
        maxPrice = max(prices)
        maxIndex = prices.index(maxPrice)

        for i in range(maxIndex):
            spent += prices[i]
            shares += 1

        if shares > 0:
            answer += shares * maxPrice - spent

        prices = prices[maxIndex + 1:]
        spent, shares = 0, 0

    return answer


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        prices = list(map(int, input().rstrip().split()))

        result = stockmax(prices)

        fptr.write(str(result) + '\n')

    fptr.close()
