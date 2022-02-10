using System.Collections.Concurrent;

namespace c_sharp.Week_2;

class ResultMaximumElement
{
    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<int> getMax(List<string> operations)
    {
        var output = new List<int>();
        var max = -1;
        var queue = new ConcurrentStack<int>();

        foreach (var operation in operations)
        {
            switch (operation[0])
            {
                case '1':
                    var number = int.Parse(operation.Split(' ')[1]);
                    queue.Push(number);

                    if (number > max)
                    {
                        max = number;
                    }
                    break;
                case '2':
                {
                    queue.TryPop(out var pop);
                    if (pop == max)
                    {
                        max = queue.Count > 0 ? queue.Max() : 0;
                    }

                    break;
                }
                case '3':
                    output.Add(max);
                    break;
            }
        }

        return output;
    }
}

class SolutionMaximumElement
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int n = Convert.ToInt32(Console.ReadLine().Trim());

        List<string> ops = new List<string>();

        for (int i = 0; i < n; i++)
        {
            string opsItem = Console.ReadLine();
            ops.Add(opsItem);
        }

        List<int> res = ResultMaximumElement.getMax(ops);

        textWriter.WriteLine(String.Join("\n", res));

        textWriter.Flush();
        textWriter.Close();
    }
}