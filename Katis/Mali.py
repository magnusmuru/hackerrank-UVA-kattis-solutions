A, B = [0 for i in range(101)], [0 for i in range(101)]

for i in range(int(input())):
    data = input().split()

    a = int(data[0])
    b = int(data[1])

    A[a] += 1
    B[b] += 1

    a, b = 100, 1
    current_a, current_b = 0, 0
    current_answer = 0

    while True:
        while a > 0 and A[a] == 0:
            a -= 1
        while b < 101 and B[b] == 0:
            b += 1
        if a == 0 or b == 101:
            break

        if current_a == 0:
            current_a = A[a]

        if current_b == 0:
            current_b = B[b]

        if a + b > current_answer:
            current_answer = a + b

        if current_a > current_b:
            current_a -= current_b
            current_b = 0
            b += 1

        elif current_b > current_a:
            current_b -= current_a
            current_a = 0
            a -= 1

        else:
            a -= 1
            b += 1
            current_a, current_b = 0, 0

    print(current_answer)
