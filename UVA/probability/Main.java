import java.util.Scanner;

class Main {
    void Begin() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.next());

        for (int testCase = 0; testCase < testCases; testCase++) {

            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double S = scanner.nextDouble();

            double result = 0;

            if (a <= 0 || b <= 0 || S >= a * b) {
                result = 0;
            } else if (S == 0) {
                result = 100;
            } else {
                result = ((a * b - S - S * Math.log(a) - S * Math.log(b) + S * Math.log(S)) * 100) / (a * b);
            }

            System.out.printf("%.6f%%\n", result);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Main myWork = new Main();
        myWork.Begin();
    }
}