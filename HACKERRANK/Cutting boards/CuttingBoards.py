#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'boardCutting' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY cost_y
#  2. INTEGER_ARRAY cost_x
#

def boardCutting(cost_y, cost_x):
    row = 1
    column = 1

    length_cuts = sorted(cost_y, reverse=True)
    width_cuts = sorted(cost_x, reverse=True)

    output = 0
    for _ in range(len(cost_y) + len(cost_x)):

        if (length_cuts != [] and width_cuts != [] and length_cuts[0] >= width_cuts[0]) or (
                width_cuts == [] and length_cuts != []):
            output += row * length_cuts[0]
            column += 1
            length_cuts.remove(length_cuts[0])

        elif (width_cuts != []) or (length_cuts == [] and width_cuts != []):
            output += column * width_cuts[0]
            row += 1
            width_cuts.remove(width_cuts[0])
    return output % (pow(10, 9) + 7)


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        m = int(first_multiple_input[0])

        n = int(first_multiple_input[1])

        cost_y = list(map(int, input().rstrip().split()))

        cost_x = list(map(int, input().rstrip().split()))

        result = boardCutting(cost_y, cost_x)

        fptr.write(str(result) + '\n')

    fptr.close()
