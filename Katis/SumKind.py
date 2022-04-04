for i in range(int(input())):
    problem, n = list(map(int, input().split(' ')))

    s1 = 0
    sum1 = 0

    s2 = 0
    sum2 = 0

    s3 = 0
    sum3 = 0

    current = 0
    while True:
        current += 1
        if s1 < n:
            s1 += 1
            sum1 += current

        if s2 < n and current % 2 != 0:
            s2 += 1
            sum2 += current

        if s3 < n and current % 2 == 0:
            s3 += 1
            sum3 += current

        if s3 == s2 == s1 == n:
            break

    print("{} {} {} {}".format(problem, sum1, sum2, sum3))
