namespace c_sharp.Week4;

class Result
{
    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static long candies(int n, List<int> arr)
    {
        var score = arr.Select(i => 1).ToList();

        for (var i = 0; i < n - 1; i++)
        {
            if (arr[i] < arr[i + 1])
            {
                score[i + 1] = score[i] + 1;
            }
        }

        for (var i = n - 1; i > 0; i--)
        {
            if (arr[i] >= arr[i - 1]) continue;
            if (score[i - 1] <= score[i])
            {
                score[i - 1] = score[i] + 1;
            }
        }

        // C# Magic to return long value instead of int since it goes out of 32-bit number range. Otherwise would use .Sum()
        return score.Aggregate<int, long>(0, (current, t) => current + t);
    }
}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int n = Convert.ToInt32(Console.ReadLine().Trim());

        List<int> arr = new List<int>();

        for (int i = 0; i < n; i++)
        {
            int arrItem = Convert.ToInt32(Console.ReadLine().Trim());
            arr.Add(arrItem);
        }

        long result = Result.candies(n, arr);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}