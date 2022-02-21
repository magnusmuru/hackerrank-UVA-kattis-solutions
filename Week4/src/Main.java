import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {

    void Begin() {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        while (scanner.hasNext()) {
            String[] intArray = scanner.nextLine().split("\\s+");

            int scores = Integer.parseInt(intArray[0]);
            int instruments = Integer.parseInt(intArray[1]);
            scores -= instruments;

            priorityQueue.addAll(Arrays.stream((scanner.nextLine().split("\\s+"))).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));

            while (scores > 0) {
                double highest = priorityQueue.poll() / 2;
                priorityQueue.add((int) Math.floor(highest));
                priorityQueue.add((int) Math.ceil(highest));
                scores -= 1;
            }
            out.append(String.valueOf(priorityQueue.peek())).append("\n");
            priorityQueue.clear();
        }
        out.flush();
    }

    public static void main(String[] args) {
        Main myWork = new Main();
        myWork.Begin();
    }
}