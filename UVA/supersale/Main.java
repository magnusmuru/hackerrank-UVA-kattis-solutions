import java.util.Scanner;

class Main {
    void Begin() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.next());

        for (int testCase = 0; testCase < testCases; testCase++) {

            int storeItems = Integer.parseInt(scanner.next());

            int[] prices = new int[storeItems + 1];
            int[] weights = new int[storeItems + 1];

            for (int i = 1; i <= storeItems; i++) {
                prices[i] = Integer.parseInt(scanner.next());
                weights[i] = Integer.parseInt(scanner.next());
            }

            int shoppingPeople = Integer.parseInt(scanner.next());
            int[] peoplesWeights = new int[shoppingPeople];

            int W = 0;

            for (int i = 0; i < shoppingPeople; i++) {
                int personWeight = Integer.parseInt(scanner.next());
                peoplesWeights[i] = personWeight;
                W = Math.max(personWeight, W);
            }

            int[][] itemWeights = new int[storeItems + 1][W + 1];

            for (int i = 1; i <= storeItems; i++) {
                for (int j = 1; j <= W; j++) {
                    if (j >= weights[i]) {
                        itemWeights[i][j] = Math.max(prices[i] + itemWeights[i - 1][j - weights[i]], itemWeights[i - 1][j]);
                    } else {
                        itemWeights[i][j] = itemWeights[i - 1][j];
                    }
                }
            }

            int output = 0;

            for (int i = 0; i < shoppingPeople; i++) {
                output += itemWeights[storeItems][peoplesWeights[i]];
            }

            System.out.println(output);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Main myWork = new Main();
        myWork.Begin();
    }
}