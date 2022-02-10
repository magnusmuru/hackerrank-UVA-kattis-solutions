namespace c_sharp.Week_2;

using System.Collections.Generic;
using System.IO;
using System.Linq;
using System;

class Result
{
    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<int> h1, List<int> h2, List<int> h3)
    {
        var h1Height = new List<int> { h1.Sum() };
        var h2Height = new List<int> { h2.Sum() };
        var h3Height = new List<int> { h3.Sum() };

        foreach (var number in h1)
        {
            h1Height.Add(h1Height.Last() - number);
        }
        
        foreach (var number in h2)
        {
            h2Height.Add(h2Height.Last() - number);
        }

        foreach (var number in h3)
        {
            h3Height.Add(h3Height.Last() - number);
        }

        var heightTotals = h1Height.Intersect(h2Height).Intersect(h3Height);

        return heightTotals.First();
    }
}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string[] firstMultipleInput = Console.ReadLine().TrimEnd().Split(' ');

        int n1 = Convert.ToInt32(firstMultipleInput[0]);

        int n2 = Convert.ToInt32(firstMultipleInput[1]);

        int n3 = Convert.ToInt32(firstMultipleInput[2]);

        List<int> h1 = Console.ReadLine().TrimEnd().Split(' ').ToList().Select(h1Temp => Convert.ToInt32(h1Temp))
            .ToList();

        List<int> h2 = Console.ReadLine().TrimEnd().Split(' ').ToList().Select(h2Temp => Convert.ToInt32(h2Temp))
            .ToList();

        List<int> h3 = Console.ReadLine().TrimEnd().Split(' ').ToList().Select(h3Temp => Convert.ToInt32(h3Temp))
            .ToList();

        int result = Result.equalStacks(h1, h2, h3);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}