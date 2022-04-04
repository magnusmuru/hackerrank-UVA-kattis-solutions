using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Result
{
    /*
     * Complete the 'unboundedKnapsack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int unboundedKnapsack(int k, List<int> arr)
    {
        return KnapSack(arr, k, arr.Count);
    }

    public static int KnapSack(List<int> numberList, int target, int n)
    {
        if (n == 0 || target <= 0)
        {
            return 0;
        }

        if (numberList[n - 1] <= target)
        {
            return Math.Max(numberList[n - 1] + KnapSack(numberList, target - numberList[n - 1], n),
                KnapSack(numberList, target, n - 1));
        }

        return numberList[n - 1] > target ? KnapSack(numberList, target, n - 1) : 0;
    }
}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int t = Convert.ToInt32(Console.ReadLine().Trim());

        while (t > 0)
        {
            string[] firstMultipleInput = Console.ReadLine().TrimEnd().Split(' ');

            int n = Convert.ToInt32(firstMultipleInput[0]);

            int k = Convert.ToInt32(firstMultipleInput[1]);

            List<int> arr = Console.ReadLine().TrimEnd().Split(' ').ToList().Select(arrTemp => Convert.ToInt32(arrTemp))
                .ToList();

            int result = Result.unboundedKnapsack(k, arr);
            textWriter.WriteLine(result);
            t--;
        }

        textWriter.Flush();
        textWriter.Close();
    }
}