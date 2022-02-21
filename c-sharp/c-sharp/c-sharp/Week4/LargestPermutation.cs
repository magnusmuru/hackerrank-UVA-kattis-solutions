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
     * Complete the 'largestPermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */
    public static List<int> largestPermutation(int k, List<int> arr)
    {
        var count = 0;
        var intDictionary = arr.ToDictionary(x => x, y =>
        {
            var res = count;
            count++;
            return res;
        });
        var i = 0;
        while (k > 0 && i < arr.Count)
        {
            if (arr[i] < arr.Count - i)
            {
                var currentValue = arr[i];
                var position = intDictionary[arr.Count - i];

                arr[position] = arr[i];
                arr[i] = arr.Count - i;
                intDictionary[arr.Count - i] = i;
                intDictionary[currentValue] = position;

                k--;
            }

            i++;
        }

        return arr;
    }
}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string[] firstMultipleInput = Console.ReadLine().TrimEnd().Split(' ');

        int n = Convert.ToInt32(firstMultipleInput[0]);

        int k = Convert.ToInt32(firstMultipleInput[1]);

        List<int> arr = Console.ReadLine().TrimEnd().Split(' ').ToList().Select(arrTemp => Convert.ToInt32(arrTemp))
            .ToList();

        List<int> result = Result.largestPermutation(k, arr);

        textWriter.WriteLine(String.Join(" ", result));

        textWriter.Flush();
        textWriter.Close();
    }
}