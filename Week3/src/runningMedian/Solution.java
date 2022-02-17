package runningMedian;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> minimumHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maximumHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Double> result = new ArrayList<>();

        double median = 0.0;
        for (Integer integer : a) {

            if (integer > median) minimumHeap.offer(integer);
            else maximumHeap.offer(integer);

            if (maximumHeap.size() - minimumHeap.size() > 1) {
                minimumHeap.offer(maximumHeap.poll());
            } else if (minimumHeap.size() - maximumHeap.size() > 1) {
                maximumHeap.offer(minimumHeap.poll());
            }

            if (minimumHeap.size() == maximumHeap.size()) {
                median = (minimumHeap.peek() + maximumHeap.peek()) / 2.0;
                result.add(median);
            } else if (minimumHeap.size() > maximumHeap.size()) {
                median = (double) minimumHeap.peek();
                result.add(median);
            } else {
                median = (double) maximumHeap.peek();
                result.add(median);
            }
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
