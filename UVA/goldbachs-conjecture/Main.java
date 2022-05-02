import java.util.*;


class Main {

    boolean[] eratosthenes(int n) {
        boolean[] nPrimes = new boolean[n + 1];
        Arrays.fill(nPrimes, true);

        for (int p = 2; p * p <= n; p++) {
            if (nPrimes[p]) {
                for (int i = p * p; i <= n; i += p)
                    nPrimes[i] = false;
            }
        }

        return nPrimes;
    }

    void Begin() {
        Scanner scanner = new Scanner(System.in);

        boolean[] nPrimes = eratosthenes(1000000);

        while (scanner.hasNext()) {
            int testCase = Integer.parseInt(scanner.next());
            if (testCase == 0) {
                break;
            }
            for (int i = 3; i < testCase; i++) {
                if (nPrimes[i]) {

                    int higherNumber = testCase - i;

                    if (nPrimes[higherNumber]) {
                        System.out.printf("%d = %d + %d\n", testCase, i, higherNumber);
                        break;
                    }
                }
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Main myWork = new Main();
        myWork.Begin();
    }
}