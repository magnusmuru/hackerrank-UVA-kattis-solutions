import java.util.Arrays;
import java.util.Scanner;

class Main {

    void Begin() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] intArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int height = intArray[0];
            int width = intArray[1];

            if (height == 0) {
                break;
            }

            int[][] map = new int[height][width];
            for (int i = 0; i < height; i++) {

                map[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            int queryCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < queryCount; i++) {
                int[] query = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int currentMax = 0;
                for (int j = 0; j < height; j++) {

                    if (currentMax >= height - j) {
                        break;
                    }

                    int index = lower(map[j], query[0]);

                    for (int k = 0; k < width; k++) {
                        if (j + k >= height ||index + k >= width || map[j + k][index + k] > query[1]) {
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

    static int lower(int[] array, int key)
    {
        int lowerBound = 0;

        while (lowerBound < array.length) {

            if (key > array[lowerBound])
                lowerBound++;

            else
                return lowerBound;
        }

        return lowerBound;
    }

    public static void main(String[] args) {
        Main myWork = new Main();
        myWork.Begin();
    }
}
