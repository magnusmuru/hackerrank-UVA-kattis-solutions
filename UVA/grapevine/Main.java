import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {

    void Begin() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] intArray = Arrays.stream(scanner.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (intArray[0] == 0 && intArray[1] == 0) {
                break;
            }

            int[][] map = new int[intArray[0]][intArray[1]];
            for (int i = 0; i < intArray[0]; i++) {

                map[i] = Arrays.stream(scanner.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            int queryCount = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < queryCount; i++) {
                int[] query = Arrays.stream(scanner.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int currentMax = 0;
                for (int j = 0; j < intArray[0]; j++) {
                    OptionalInt optionalIndex = IntStream.of(map[j]).filter(x -> x >= query[0] && x <= query[1]).findFirst();
                    if (!optionalIndex.isPresent()) {
                        continue;
                    }

                    int index = Arrays.binarySearch(map[j], optionalIndex.getAsInt());


                    if (currentMax >= intArray[0] - j) {
                        break;
                    }

                    for (int k = 0; k < intArray[1]; k++) {
                        if (index + k >= intArray[1] || i + k >= intArray[0] || map[i + k][index + k] > query[1]) {
                            break;
                        }
                        if (k + 1 > currentMax) {
                            currentMax = k + 1;
                        }
                    }
                }
                System.out.printf("%s\n", currentMax);
            }
            System.out.println("-");
        }
    }

    public static void main(String[] args) {
        Main myWork = new Main();
        myWork.Begin();
    }
}
