namespace c_sharp.Week_2;


class SolutionQueue {
    static void Main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int n = Convert.ToInt32(Console.ReadLine().Trim());

        List<string> ops = new List<string>();

        for (int i = 0; i < n; i++)
        {
            string opsItem = Console.ReadLine();
            ops.Add(opsItem);
        }

        List<int> res = QueueElements.getMax(ops);

        textWriter.WriteLine(String.Join("\n", res));

        textWriter.Flush();
        textWriter.Close();
    }
}

class QueueElements
{
    public static List<int> getMax(List<string> operations)
    {
        var output = new List<int>();
        var queue = new Queue<int>();
        foreach (var operation in operations)
        {
            switch (operation[0])
            {
                case '1':
                    var number = int.Parse(operation.Split(' ')[1]);
                    queue.Enqueue(number);
                    break;
                case '2':
                {
                    queue.Dequeue();
                    break;
                }
                case '3':
                    output.Add(queue.Peek());
                    break;
            }
        }

        return output;
    }
}