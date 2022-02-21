#include <bits/stdc++.h>

using namespace std;

int main() {
    int p, n;
    while (scanf("%d %d", &p, &n) == 2) {
        static int A[200000];

        int lower = 1, maximum = 0;

        for (int i = 0; i < n; i++) {
            scanf("%d", &A[i]);
            maximum = max(maximum, A[i]);
        }
        int output = 1;
        while (lower <= maximum) {
            int average_value = (lower + maximum) / 2;
            int check_sum = 0;

            for (int i = 0; i < n; i++)
                check_sum += (A[i] + average_value - 1) / average_value;

            if (check_sum <= p)
                maximum = average_value - 1, output = average_value;
            else
                lower = average_value + 1;
        }
        printf("%d\n", output);
    }
    return 0;
}